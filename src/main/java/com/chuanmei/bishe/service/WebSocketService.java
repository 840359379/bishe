package com.chuanmei.bishe.service;

import com.chuanmei.bishe.configure.MyTool;
import com.chuanmei.bishe.configure.RedisTool;
import com.chuanmei.bishe.model.Socket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


@ServerEndpoint("/line/{account}")
@Component
@Slf4j
public class WebSocketService {

    private static SocketService socketService;
    @Autowired
    public void setRedisTemplate(SocketService socketService) {
        WebSocketService.socketService = socketService;
    }

    private static int onlineCount = 0;
    /**concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
    private static ConcurrentHashMap<String,WebSocketService> webSocketMap = new ConcurrentHashMap<>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**接收userId*/
    private String account="";

    @OnOpen
    public void onOpen(Session session,@PathParam("account") String account) {
        this.session = session;
        this.account=account;
        if(webSocketMap.containsKey(account)){
            webSocketMap.remove(account);
            webSocketMap.put(account,this);
            //加入set中
        }else{
            webSocketMap.put(account,this);
            //加入set中
            addOnlineCount();
            //在线数加1
            log.info("有新的客户端连接了: {}", session.getId());
        }
        log.info("用户连接:"+account+",当前在线人数为:" + getOnlineCount());
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("用户:"+account+",网络异常!!!!!!");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if(webSocketMap.containsKey(account)){
            webSocketMap.remove(account);
            //从set中删除
            subOnlineCount();
        }
        log.info("用户退出:"+account+",当前在线人数为:" + getOnlineCount());
    }


    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户消息:"+account+",报文:"+message);
        //可以群发消息
        //消息保存到数据库、redis
        if(account!=""&&account!=null){
            try {
                //解析发送的报文
                JSONObject jsonObject = JSON.parseObject(message);
                //追加发送人(防止串改)
                jsonObject.put("account",this.account);
                String cover = jsonObject.getString("cover");
                String content = jsonObject.getString("content");
                //传送给对应toAccount用户的websocket
                if(cover!=""&&cover!=null&&webSocketMap.containsKey(cover)){
                    Socket socket = new Socket(MyTool.combination(cover,account),null,account,cover,
                            null,0,null,0,content);
                    socketService.addSocket(socket);
                    webSocketMap.get(cover).sendMessage(jsonObject.toJSONString());
                    webSocketMap.get(account).sendMessage(jsonObject.toJSONString());
                }else{
                    log.error("请求的account:"+cover+"不在该服务器上");
                    webSocketMap.get(account).sendMessage(jsonObject.toJSONString());
                    Socket socket = new Socket(MyTool.combination(cover,account),null,account,cover,
                            null,1,null,0,content);
                    socketService.addSocket(socket);
                    //否则不在这个服务器上，发送到mysql或者redis
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:"+this.account+",原因:"+error.getMessage());
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送自定义消息
     * */
    public static void sendInfo(String message,@PathParam("account") String account) throws IOException {
        log.info("发送消息到:"+account+"，报文:"+message);
        if(account!=""&&account!=null&&webSocketMap.containsKey(account)){
            webSocketMap.get(account).sendMessage(message);
        }else{
            log.error("用户"+account+",不在线！");
        }
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketService.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketService.onlineCount--;
    }

}
