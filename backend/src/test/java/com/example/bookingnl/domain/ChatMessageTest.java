package com.example.bookingnl.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChatMessageTest {

    @Test
    void chatMessageConstructor() {
        ChatMessage actualChatMessage = new ChatMessage();
        actualChatMessage.setDate("2020-03-01");
        actualChatMessage.setMessage("Not all who wander are lost");
        actualChatMessage.setReceiverName("Receiver Name");
        actualChatMessage.setSenderName("Sender Name");
        String actualToStringResult = actualChatMessage.toString();
        assertEquals("2020-03-01", actualChatMessage.getDate());
        assertEquals("Not all who wander are lost", actualChatMessage.getMessage());
        assertEquals("Receiver Name", actualChatMessage.getReceiverName());
        assertEquals("Sender Name", actualChatMessage.getSenderName());
        assertEquals("ChatMessage(senderName=Sender Name, receiverName=Receiver Name, message=Not all who wander are lost,"
                + " date=2020-03-01)", actualToStringResult);
    }



}

