package com.soptkathonserverandroid2.domain.recommend.service;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.issue.repository.IssueRepository;
import com.soptkathonserverandroid2.domain.recommend.entity.Recommend;
import com.soptkathonserverandroid2.domain.recommend.repository.RecommendRepository;
import com.soptkathonserverandroid2.domain.user.entity.User;
import com.soptkathonserverandroid2.domain.user.repository.UserRepository;
import com.soptkathonserverandroid2.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.soptkathonserverandroid2.global.exception.code.ErrorCode.ISSUE_NOT_FOUND;
import static com.soptkathonserverandroid2.global.exception.code.ErrorCode.USER_NOT_FOUND;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class RecommendService {

    private final RecommendRepository recommendRepository;
    private final UserRepository userRepository;
    private final IssueRepository issueRepository;

    @Transactional
    public void createRecommend(Long userId, Long issueId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));

        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new NotFoundException(ISSUE_NOT_FOUND));

        Recommend recommend = recommendRepository.findByUserAndIssue(user, issue)
                .orElseGet(() -> {
                    Recommend newRecommend = Recommend.create(user, issue);
                    return recommendRepository.save(newRecommend);
                });

        recommend.recommend();
    }
}
