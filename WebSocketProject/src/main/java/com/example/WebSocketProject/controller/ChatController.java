package com.example.WebSocketProject.controller;

import com.example.WebSocketProject.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload final ChatMessage chatMessage){
        return chatMessage;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/public")
    public ChatMessage newUser(@Payload final ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor){
        // adds the user to the websocket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
