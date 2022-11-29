package com.example.WebSocketProject.model;

import lombok.Builder;
import lombok.Getter;

// Builder -> design pattern enable to create an object with optional parameters
@Builder
public class ChatMessage {
    @Getter
    private MessageType type;
    @Getter
    private String content;
    @Getter
    private String sender;
    @Getter
    private String time;
}
