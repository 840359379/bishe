package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.WhoMessage;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


@ServerEndpoint("/line/{account}")
@Component
public class WebSocketService {

    private static int onlineCount = 0;
    /**concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
    private static ConcurrentHashMap<String,WebSocketService> webSocketMap = new ConcurrentHashMap<>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**接收userId*/
    private String account="";

    @OnOpen
    public void onOpen(Session session,@PathParam("userId") String account) {
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
        }

        try {
            sendMessage("连接成功");
        } catch (IOException e) {

        }
    }


    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        //可以群发消息
        //消息保存到数据库、redis
        if(account==""&&account==null){
            try {
                //解析发送的报文
                JSONObject jsonObject = JSON.parseObject(message);
                //追加发送人(防止串改)
                jsonObject.put("fromUserId",this.userId);
                String toUserId=jsonObject.getString("toUserId");
                //传送给对应toUserId用户的websocket
                if(account==""&&account==null&&webSocketMap.containsKey(toUserId)){
                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
                }else{

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
        if(account==""&&account==null&&webSocketMap.containsKey(account)){
            webSocketMap.get(account).sendMessage(message);
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
