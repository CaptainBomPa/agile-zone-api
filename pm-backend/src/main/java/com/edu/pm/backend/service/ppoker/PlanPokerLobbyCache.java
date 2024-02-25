package com.edu.pm.backend.service.ppoker;

import com.edu.pm.backend.model.User;
import com.edu.pm.backend.service.ppoker.messagetypes.UserVotes;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@Getter
public class PlanPokerLobbyCache {
    private boolean opened = false;
    private boolean started = false;
    private String storyName;
    private Set<UserVotes> votes = Collections.synchronizedSet(new HashSet<>());
    private VoteResult previousResult;

    public void openLobby(String storyName) {
        if (!opened && !started) {
            opened = true;
            this.storyName = storyName;
        } else {
            throw new IllegalArgumentException("Lobby is already opened or started. Cannot create new.");
        }
    }

    public void startLobby() {
        if (opened && !started) {
            started = true;
        } else {
            throw new IllegalArgumentException("Lobby is already opened or started. Cannot start lobby now.");
        }
    }

    public void joinLobby(User user) {
        if (opened && !started) {
            votes.add(new UserVotes(user));
        } else {
            throw new IllegalArgumentException("Lobby is not opened or voting started. Cannot join");
        }
    }

    public void putVote(User user, Integer value) {
        if (opened && started) {
            UserVotes userVotes = new UserVotes(user, value == null ? new BigDecimal(0) : new BigDecimal(value));
            if (votes.contains(userVotes)) {
                votes.remove(userVotes);
                votes.add(userVotes);
            } else {
                votes.add(userVotes);
            }
        } else {
            throw new IllegalArgumentException("Lobby did not start yet. Cannot put vote");
        }
        System.out.println();
    }

    public void closeLobby() {
        if (started && opened) {
            previousResult = new VoteResult(storyName, votes);
        }
        votes = Collections.synchronizedSet(new HashSet<>());
        storyName = null;
        started = false;
        opened = false;
    }

}
