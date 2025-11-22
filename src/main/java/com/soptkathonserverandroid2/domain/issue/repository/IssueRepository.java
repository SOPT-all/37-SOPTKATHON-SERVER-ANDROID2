package com.soptkathonserverandroid2.domain.issue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long>, IssueCustomRepository {

	Issue findTopByIsPassedFalseOrderByRecommendCountDesc();

	List<Issue> findAllByIsPassedTrueOrderByIsCouncilDesc();
}
