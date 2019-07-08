package com.kotor.controllers;

import com.kotor.lamps.Lampe;
import com.kotor.logic.Greeting;
import com.kotor.logic.HelloMessage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MainController {
    private volatile static Lampe lampe = new Lampe(false);

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Boolean greeting() throws Exception {
        return lampe.OnOrOffLampe();
    }

    @MessageMapping("/check")
    @SendTo("/topic/greetings")
    public Boolean check() {
        return lampe.isActive();
    }
}
