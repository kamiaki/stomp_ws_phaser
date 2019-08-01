package com.cnblogs.yjmyzz.websocket.demo.controller;

import com.cnblogs.yjmyzz.websocket.demo.consts.GlobalConsts;
 import com.cnblogs.yjmyzz.websocket.demo.model.PlayerInfoMsg;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
 import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

 import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping(GlobalConsts.mapping1)
    @SendTo(GlobalConsts.subM + GlobalConsts.sub1)
    public PlayerInfoMsg playerInfo(PlayerInfoMsg message) throws Exception {
        System.out.println(message);
        return message;
    }

    @Scheduled(fixedRate = 1000)
    public String serverTime() {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messagingTemplate.convertAndSend(
                GlobalConsts.subM + GlobalConsts.sub1,
                df.format(new Date())
        );
        return "servertime";
    }
}
