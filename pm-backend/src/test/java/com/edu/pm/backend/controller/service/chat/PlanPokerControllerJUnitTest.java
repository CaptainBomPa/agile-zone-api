package com.edu.pm.backend.controller.service.chat;

import com.edu.pm.backend.service.ppoker.PlanPokerController;
import com.edu.pm.backend.service.ppoker.PlanPokerLobbyCache;
import com.edu.pm.backend.service.ppoker.messagetypes.LobbyOpenedDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class PlanPokerControllerJUnitTest {

    @Mock
    PlanPokerLobbyCache lobbyCache;
    PlanPokerController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new PlanPokerController(lobbyCache);
    }

    @Test
    void changeLobbyOpenedSuccessfullyOpensTheLobby() {
        // Given: A lobby opened DTO
        LobbyOpenedDTO dto = new LobbyOpenedDTO(true, false, "Story 1");

        // When: changeLobbyOpened is called
        LobbyOpenedDTO result = controller.changeLobbyOpened(dto);

        // Then: Lobby is opened
        verify(lobbyCache).openLobby("Story 1");
        assertTrue(result.isLobbyOpened());
        assertFalse(result.isLobbyStarted());
        assertEquals("Story 1", result.getUserStoryName());
    }

}
