package com.edu.pm.backend.service.ppoker.messagetypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanPokerCurrentStateDTO {
    private boolean opened = false;
    private boolean started = false;
    private String storyName;
    private Set<UserVotes> votes = new HashSet<>();
}
