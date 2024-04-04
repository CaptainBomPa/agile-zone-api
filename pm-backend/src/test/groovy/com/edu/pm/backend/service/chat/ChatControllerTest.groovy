package com.edu.pm.backend.service.chat

import com.edu.pm.backend.model.Message
import com.edu.pm.backend.model.User
import com.edu.pm.backend.repository.MessageRepository
import org.springframework.messaging.simp.SimpMessagingTemplate
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDateTime

class ChatControllerTest extends Specification {

    @Subject
    ChatController chatController

    def messageRepository = Mock(MessageRepository)
    def simpMessagingTemplate = Mock(SimpMessagingTemplate.class)

    def setup() {
        chatController = new ChatController(messageRepository, simpMessagingTemplate)
    }

    def "receiveMessage sets timestamp, saves and sends message"() {
        given: "A message without timestamp"
        LocalDateTime beforeTest = LocalDateTime.now()
        Message message = new Message()
        message.setContent("Hello, World!")
        message.setReceiver(new User(id: 1))

        when: "receiveMessage is called"
        chatController.receiveMessage(message)

        then: "Message timestamp is set to current time"
        assert message.getTimestamp().isAfter(beforeTest) || message.getTimestamp().isEqual(beforeTest)

        and: "Message is saved"
        1 * messageRepository.save(_ as Message) >> { Message savedMsg ->
            assert savedMsg.getTimestamp() != null
            return savedMsg
        }

        and: "Message is sent to the correct destination"
        1 * simpMessagingTemplate.convertAndSend("/topic/1/messages", message)
    }
}

