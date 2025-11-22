package com.soptkathonserverandroid2.domain.vote.repository;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.user.entity.User;
import com.soptkathonserverandroid2.domain.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByUserAndIssue(User user, Issue issue);

	Vote findByUserAndIssue(User user, Issue issue);
}
