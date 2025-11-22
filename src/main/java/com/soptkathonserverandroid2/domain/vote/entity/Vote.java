package com.soptkathonserverandroid2.domain.vote.entity;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vote {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isAgree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    private Issue issue;

    public static Vote create(User user, Issue issue, boolean isAgree) {
        Vote vote = new Vote();
        vote.user = user;
        vote.issue = issue;
        vote.isAgree = isAgree;
        return vote;
    }
}
