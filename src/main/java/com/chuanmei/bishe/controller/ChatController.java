//package com.chuanmei.bishe.controller;
//
//import com.google.gson.Gson;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import javax.websocket.OnClose;
//import javax.websocket.OnError;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//
//
//@ServerEndpoint("/test-one")
//@Component
//@Slf4j
//public class MyOneToOneServer {
//    /**
//     * 用于存放所有在线客户端
//     */
//    private static Map<String, Session> clients = new ConcurrentHashMap<>();
//
//    private Gson gson = new Gson();
//
//    @OnOpen
//    public void onOpen(Session session) {
//        log.info("有新的客户端上线: {}", session.getId());
//        clients.put(session.getId(), session);
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        String sessionId = session.getId();
//        log.info("有客户端离线: {}", sessionId);
//        clients.remove(sessionId);
//    }
//
//    @OnError
//    public void onError(Session session, Throwable throwable) {
//        throwable.printStackTrace();
//        if (clients.get(session.getId()) != null) {
//            clients.remove(session.getId());
//        }
//    }
//
//    @OnMessage
//    public void onMessage(String message) {
//        log.info("收到客户端发来的消息: {}", message);
//        this.sendTo(gson.fromJson(message, Message.class));
//    }
//
//    /**
//     * 发送消息
//     *
//     * @param message 消息对象
//     */
//    private void sendTo(Message message) {
//        Session s = clients.get(message.getUserId());
//        if (s != null) {
//            try {
//                s.getBasicRemote().sendText(message.getMessage());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
