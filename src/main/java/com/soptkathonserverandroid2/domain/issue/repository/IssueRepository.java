package com.soptkathonserverandroid2.domain.issue.repository;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
