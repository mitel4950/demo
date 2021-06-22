package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MessageConfig {
    @Bean
    public Message printMessage() {
        return new Message();
    }
}

