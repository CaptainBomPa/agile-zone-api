package com.edu.pm.backend.service.ppoker.messagetypes;

import com.edu.pm.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
public class UserVotes {
    private User user;
    private BigDecimal vote;

    public UserVotes(User user) {
        this.user = user;
        this.vote = new BigDecimal(0);
    }

    public UserVotes(User user, BigDecimal vote) {
        this.user = user;
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVotes userVotes = (UserVotes) o;
        return Objects.equals(this.getUser().getId(), userVotes.getUser().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getId());
    }
}
