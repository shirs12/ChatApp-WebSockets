package com.example.WebSocketProject.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMessageConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry){
        registry.addEndpoint("/chat-example").withSockJS(); // provides a web socket objects
    }

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry){
        registry.setApplicationDestinationPrefixes("/app"); // what is behind all the message mapping annotations
        registry.enableSimpleBroker("/topic"); // carry the chat messages back to the client
    }
}
