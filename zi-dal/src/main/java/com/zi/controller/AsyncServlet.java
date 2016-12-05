package com.zi.controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by Administrator on 2016/11/23.
 */
@ServerEndpoint("/ws")
public class AsyncServlet {
    private String currentUser;
    //连接打开时执行
    @OnOpen
    public void onOpen( Session session) {
        System.out.println("Connected ... " + session.getId());
    }

    //收到消息时执行
    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println(currentUser + "：" + message);
        return currentUser + "：" + message;
    }

    //连接关闭时执行
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }

    //连接错误时执行
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
