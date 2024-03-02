package com.edu.pm.backend.service.ppoker

import com.edu.pm.backend.model.User
import com.edu.pm.backend.service.ppoker.messagetypes.*
import org.springframework.http.HttpStatus
import spock.lang.Specification

class PlanPokerControllerTest extends Specification {

    PlanPokerController controller
    PlanPokerLobbyCache lobbyCache = Mock()

    void setup() {
        controller = new PlanPokerController(lobbyCache)
    }

    def "change lobby opened successfully opens the lobby"() {
        given: "A lobby opened DTO"
        def dto = new LobbyOpenedDTO(true, false, "Story 1")

        when: "changeLobbyOpened is called"
        def result = controller.changeLobbyOpened(dto)

        then: "Lobby is opened"
        1 * lobbyCache.openLobby("Story 1")
        result.lobbyOpened
        result.userStoryName == "Story 1"
    }

    def "change lobby started successfully starts the lobby"() {
        given: "A lobby started DTO"
        def dto = new LobbyStartedDTO(true)

        when: "changeLobbyStarted is called"
        def result = controller.changeLobbyStarted(dto)

        then: "Lobby is started"
        1 * lobbyCache.startLobby()
        result.lobbyStarted
    }

    def "join lobby adds a user to the lobby"() {
        given: "A join lobby DTO"
        def user = new User(id: 1L, username: "Test User")
        def dto = new JoinLobbyDTO(user)

        when: "joinLobby is called"
        def result = controller.joinLobby(dto)

        then: "User is added to the lobby"
        1 * lobbyCache.joinLobby(user)
        result.user == user
    }

    def "put vote casts a vote"() {
        given: "A put vote DTO"
        def user = new User(id: 1L, username: "Test User")
        def dto = new PutVoteDTO(user, 5)

        when: "putVote is called"
        def result = controller.putVote(dto)

        then: "Vote is cast"
        1 * lobbyCache.putVote(user, 5)
        result.vote == 5
    }

    def "getInfo returns the current lobby state"() {
        given: "A lobby state"
        def votes = [] as Set
        def stateDto = PlanPokerCurrentStateDTO.builder()
                .opened(true)
                .started(true)
                .storyName("Story 1")
                .votes(votes)
                .build()
        lobbyCache.isOpened() >> true
        lobbyCache.isStarted() >> true
        lobbyCache.getStoryName() >> "Story 1"
        lobbyCache.getVotes() >> votes

        when: "getInfo is called"
        def response = controller.getInfo()

        then: "Current lobby state is returned"
        response.statusCode == HttpStatus.OK
        response.body.opened
        response.body.started
        response.body.storyName == "Story 1"
        response.body.votes == votes
    }

}
