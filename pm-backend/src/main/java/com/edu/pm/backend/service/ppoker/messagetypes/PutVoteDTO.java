package com.edu.pm.backend.service.ppoker.messagetypes;

import com.edu.pm.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutVoteDTO {
    private User user;
    private Integer vote;
}
