package com.edu.pm.backend.service.ppoker;

import com.edu.pm.backend.service.ppoker.messagetypes.UserVotes;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

@Getter
public class VoteResult {
    private final String userStoryName;
    private final Set<UserVotes> votes;
    private final BigDecimal summary;

    public VoteResult(String userStoryName, Set<UserVotes> votes) {
        this.userStoryName = userStoryName;
        this.votes = new HashSet<>(votes);
        if (!votes.isEmpty()) {
            BigDecimal sum = votes.stream()
                    .map(UserVotes::getVote)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            this.summary = sum.divide(new BigDecimal(votes.size()), 2, RoundingMode.HALF_UP);
        } else {
            this.summary = BigDecimal.ZERO;
        }
    }
}
