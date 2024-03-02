package com.edu.pm.backend.service.ppoker;

import com.edu.pm.backend.service.ppoker.messagetypes.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = {"http://10.0.1.64:3000", "http://localhost:3000"}, originPatterns = "*")
@RequiredArgsConstructor
public class PlanPokerController {
    private final PlanPokerLobbyCache lobby;

    @MessageMapping("/ppoker-open")
    @SendTo("/topic/ppoker-open")
    public LobbyOpenedDTO changeLobbyOpened(@Payload LobbyOpenedDTO lobbyOpenedDTO) {
        if (lobbyOpenedDTO.isLobbyOpened()) {
            lobby.openLobby(lobbyOpenedDTO.getUserStoryName());
        } else {
            lobby.closeLobby();
            lobbyOpenedDTO.setLobbyStarted(false);
        }
        return lobbyOpenedDTO;
    }

    @MessageMapping("/ppoker-start")
    @SendTo("/topic/ppoker-start")
    public LobbyStartedDTO changeLobbyStarted(@Payload LobbyStartedDTO lobbyStartedDTO) {
        if (lobbyStartedDTO.isLobbyStarted()) {
            lobby.startLobby();
        } else {
            throw new IllegalArgumentException("Lobby cannot be stopped, only closed.");
        }
        return lobbyStartedDTO;
    }

    @MessageMapping("/ppoker-join")
    @SendTo("/topic/ppoker-join")
    public JoinLobbyDTO joinLobby(@Payload JoinLobbyDTO joinLobbyDTO) {
        lobby.joinLobby(joinLobbyDTO.getUser());
        return joinLobbyDTO;
    }

    @MessageMapping("/ppoker-vote")
    @SendTo("/topic/ppoker-vote")
    public PutVoteDTO putVote(@Payload PutVoteDTO putVoteDTO) {
        lobby.putVote(putVoteDTO.getUser(), putVoteDTO.getVote());
        return putVoteDTO;
    }

    @GetMapping(value = "/ppoker-result")
    public ResponseEntity<VoteResult> getResult() {
        return ResponseEntity.ok(lobby.getPreviousResult());
    }

    @GetMapping(value = "/ppoker-info")
    public ResponseEntity<PlanPokerCurrentStateDTO> getInfo() {
        return ResponseEntity.ok(PlanPokerCurrentStateDTO.builder()
                .opened(lobby.isOpened())
                .started(lobby.isStarted())
                .votes(lobby.getVotes())
                .storyName(lobby.getStoryName())
                .build());
    }

}
