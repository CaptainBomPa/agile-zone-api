package com.edu.pm.backend.controller;

import com.edu.pm.TestUtils;
import com.edu.pm.backend.commons.dto.MessageByUsersId;
import com.edu.pm.backend.model.Message;
import com.edu.pm.backend.service.entity.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static com.edu.pm.TestUtils.createMessage;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

public class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userService);
    }

    @Test
    void testMessagesForUsers() {
        // Given
        MessageByUsersId messageByUsersId = new MessageByUsersId(1, 2);
        List<Message> expectedMessages = List.of(createMessage(1, 1, 2, "Test1", LocalDateTime.now()),
                createMessage(2, 2, 1, "Test2", LocalDateTime.now()),
                createMessage(3, 3, 1, "Test3", LocalDateTime.now()));

        // When
        when(userService.getMessagesByUsers(messageByUsersId)).thenReturn(expectedMessages);
        ResponseEntity<List<Message>> response = userController.messagesForUsers(messageByUsersId);

        // Then
        assertThat(response.getBody()).isEqualTo(expectedMessages);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
