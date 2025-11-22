package com.soptkathonserverandroid2.domain.recommend.repository;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.recommend.entity.Recommend;
import com.soptkathonserverandroid2.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    Optional<Recommend> findByUserAndIssue(User user, Issue issue);
}
