package com.edu.pm.backend.service.ppoker.messagetypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LobbyOpenedDTO {
    private boolean lobbyOpened;
    private boolean lobbyStarted;
    private String userStoryName;
}
