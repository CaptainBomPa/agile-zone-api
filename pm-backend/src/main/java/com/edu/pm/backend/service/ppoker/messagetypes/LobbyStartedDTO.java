package com.edu.pm.backend.service.ppoker.messagetypes;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LobbyStartedDTO {
    private boolean lobbyStarted;
}
