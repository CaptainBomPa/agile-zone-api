package com.edu.pm;

import com.edu.pm.backend.model.Message;
import com.edu.pm.backend.model.User;

import java.time.LocalDateTime;

public class TestUtils {

    public static Message createMessage(Integer messageId, Integer userId1, Integer userId2, String content, LocalDateTime timestamp) {
        User user1 = User.builder().id(userId1).build();
        User user2 = User.builder().id(userId2).build();
        return Message.builder()
                .id(messageId)
                .sender(user1)
                .receiver(user2)
                .content(content)
                .timestamp(timestamp)
                .build();
    }
}
