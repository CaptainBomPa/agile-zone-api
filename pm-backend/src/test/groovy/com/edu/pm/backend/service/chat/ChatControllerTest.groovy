package com.edu.pm.backend.service.chat

import com.edu.pm.backend.model.Message
import com.edu.pm.backend.repository.MessageRepository
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDateTime

class ChatControllerTest extends Specification {

    @Subject
    ChatController chatController

    def messageRepository = Mock(MessageRepository)

    def setup() {
        chatController = new ChatController(messageRepository)
    }

    def "receiveMessage sets timestamp, saves and returns message"() {
        given: "A message without timestamp"
        LocalDateTime beforeTest = LocalDateTime.now()
        Message message = new Message()
        message.setContent("Hello, World!")

        when: "receiveMessage is called"
        Message returnedMessage = chatController.receiveMessage(message)

        then: "Message timestamp is set to current time"
        assert returnedMessage.getTimestamp().isAfter(beforeTest) || returnedMessage.getTimestamp().isEqual(beforeTest)

        and: "Message is saved"
        1 * messageRepository.save(_ as Message) >> { Message savedMsg ->
            assert savedMsg.getTimestamp() != null
            return savedMsg
        }

        and: "Returned message is the same as sent message"
        returnedMessage == message
    }
}

