package com.soptkathonserverandroid2.domain.issue.service;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.issue.entity.enums.Range;
import com.soptkathonserverandroid2.domain.issue.repository.IssueRepository;
import com.soptkathonserverandroid2.domain.user.entity.User;
import com.soptkathonserverandroid2.domain.user.entity.enums.College;
import com.soptkathonserverandroid2.domain.user.entity.enums.Department;
import com.soptkathonserverandroid2.domain.user.repository.UserRepository;
import com.soptkathonserverandroid2.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.soptkathonserverandroid2.global.exception.code.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IssueService {

    private final IssueRepository issueRepository;
    private final UserRepository userRepository;

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
