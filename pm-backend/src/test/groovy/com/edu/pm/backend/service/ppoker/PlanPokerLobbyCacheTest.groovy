package com.edu.pm.backend.service.ppoker

import com.edu.pm.backend.model.User
import spock.lang.Specification

class PlanPokerLobbyCacheTest extends Specification {

    PlanPokerLobbyCache service

    def setup() {
        service = new PlanPokerLobbyCache()
    }

    def "open lobby successfully"() {
        given: "A story name"
        String storyName = "Story 1"

        when: "Open lobby is called"
        service.openLobby(storyName)

        then: "Lobby is opened with the correct story name"
        service.opened && service.storyName == storyName
    }

    def "throw exception when opening an already opened or started lobby"() {
        given: "An opened lobby"
        service.openLobby("Story 1")

        when: "Open lobby is called again"
        service.openLobby("Story 2")

        then: "An IllegalArgumentException is thrown"
        def e = thrown(IllegalArgumentException)
        e.message.contains("already opened or started")
    }

    def "start lobby successfully"() {
        given: "An opened lobby"
        service.openLobby("Story 1")

        when: "Start lobby is called"
        service.startLobby()

        then: "Lobby is started"
        service.started
    }

    def "join lobby successfully"() {
        given: "An opened lobby"
        service.openLobby("Story 1")
        User user = new User()

        when: "A user joins the lobby"
        service.joinLobby(user)

        then: "User is added to the lobby"
        service.votes.size() == 1
    }

    def "put vote successfully"() {
        given: "A started lobby and a user"
        service.openLobby("Story 1")
        User user = new User()
        service.joinLobby(user)
        service.startLobby()
        Integer voteValue = 5

        when: "A vote is cast"
        service.putVote(user, voteValue)

        then: "Vote is recorded"
        service.votes.any { it.user == user && it.vote.intValue() == voteValue }
    }

    def "close lobby successfully"() {
        given: "A started lobby"
        service.openLobby("Story 1")
        User user = new User()
        service.joinLobby(user)
        service.startLobby()
        service.putVote(user, 5)

        when: "Lobby is closed"
        service.closeLobby()

        then: "Lobby is reset"
        !service.opened && !service.started && service.storyName == null && service.votes.isEmpty()
    }
}

