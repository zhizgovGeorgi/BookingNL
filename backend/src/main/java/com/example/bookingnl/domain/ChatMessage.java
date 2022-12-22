package com.example.bookingnl.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private String content;
    private String Sender;

    public enum MessageType{
        CHAT, LEAVE, JOIN
    }
}
