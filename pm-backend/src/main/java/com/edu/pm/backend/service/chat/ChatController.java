package com.edu.pm.backend.service.chat;

import com.edu.pm.backend.model.Message;
import com.edu.pm.backend.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;

@Controller
@CrossOrigin(origins = {"http://10.0.1.64:3000", "http://localhost:3000"}, originPatterns = "*")
@RequiredArgsConstructor
public class ChatController {
    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/send")
    public void receiveMessage(@Payload Message message) {
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
        String destination = "/topic/" + message.getReceiver().getId() + "/messages";
        simpMessagingTemplate.convertAndSend(destination, message);
    }
}
