package com.soptkathonserverandroid2.domain.vote.service;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.issue.repository.IssueRepository;
import com.soptkathonserverandroid2.domain.user.entity.User;
import com.soptkathonserverandroid2.domain.user.repository.UserRepository;
import com.soptkathonserverandroid2.domain.vote.entity.Vote;
import com.soptkathonserverandroid2.domain.vote.repository.VoteRepository;
import com.soptkathonserverandroid2.global.exception.BusinessException;
import com.soptkathonserverandroid2.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.soptkathonserverandroid2.global.exception.code.ErrorCode.*;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final IssueRepository issueRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createVote(Long userId, Long issueId, boolean isAgree) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));

        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new NotFoundException(ISSUE_NOT_FOUND));

        if (voteRepository.existsByUserAndIssue(user, issue)) {
            throw new BusinessException(DUPLICATED_VOTE);
        }

        Vote vote = Vote.create(user, issue, isAgree);

        voteRepository.save(vote);
    }

}
