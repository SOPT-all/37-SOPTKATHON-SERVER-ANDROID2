package com.soptkathonserverandroid2.domain.issue.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soptkathonserverandroid2.domain.issue.dto.response.IssueInfoResponse;
import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.issue.entity.enums.Range;
import com.soptkathonserverandroid2.domain.issue.repository.IssueRepository;
import com.soptkathonserverandroid2.domain.user.entity.User;
import com.soptkathonserverandroid2.domain.user.entity.enums.College;
import com.soptkathonserverandroid2.domain.user.entity.enums.Department;
import com.soptkathonserverandroid2.domain.user.repository.UserRepository;
import com.soptkathonserverandroid2.global.exception.NotFoundException;
import com.soptkathonserverandroid2.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.soptkathonserverandroid2.global.exception.code.ErrorCode.USER_NOT_FOUND;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class IssueService {
	private final IssueRepository issueRepository;
	private final UserService userService;
	private final UserRepository userRepository;

	public IssueInfoResponse getBestIssue() {
		Issue bestIssue = issueRepository.findTopByIsPassedFalseOrderByRecommendCountDesc();
		User user = userService.getUser(bestIssue.getUser().getId());
		int remainedDay = calculateRemainedDay((bestIssue.getExpiredAt()));

		return IssueInfoResponse.of(bestIssue, user, remainedDay);

	}

	public int calculateRemainedDay(LocalDate expiredAt){
		return (int) ChronoUnit.DAYS.between(LocalDate.now(), expiredAt);
	}

	public List<IssueInfoResponse> getIssueList(Long userId, String range, String order) {
		User user = userService.getUser(userId);
		List<Issue> issueList = issueRepository.findAllByRangeWithSort(order, range, user.getCollege(), user.getDepartment());
		return issueList.stream()
			.map(issue -> IssueInfoResponse.of(
				issue,
				issue.getUser(),
				calculateRemainedDay(issue.getExpiredAt()),
				false
			))
			.toList();
	}

	@Transactional
	public void createIssue(Long userId, String title, String description, Range range) {
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));
		College college = userRepository.findCollegeById(userId);
		Department department = userRepository.findDepartmentById(userId);
		Issue issue = Issue.create(user, title, description, range, college, department);

		issueRepository.save(issue);
	}
}
