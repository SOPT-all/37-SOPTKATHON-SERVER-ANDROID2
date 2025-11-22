package com.soptkathonserverandroid2.domain.vote.service;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.issue.repository.IssueRepository;
import com.soptkathonserverandroid2.domain.issue.service.IssueService;
import com.soptkathonserverandroid2.domain.user.entity.User;
import com.soptkathonserverandroid2.domain.user.repository.UserRepository;
import com.soptkathonserverandroid2.domain.user.service.UserService;
import com.soptkathonserverandroid2.domain.vote.dto.response.VoteInfoResponse;
import com.soptkathonserverandroid2.domain.vote.entity.Vote;
import com.soptkathonserverandroid2.domain.vote.repository.VoteRepository;
import com.soptkathonserverandroid2.global.exception.BadRequestException;
import com.soptkathonserverandroid2.global.exception.BusinessException;
import com.soptkathonserverandroid2.global.exception.NotFoundException;
import com.soptkathonserverandroid2.global.exception.code.ErrorCode;

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
    private final UserService userService;
    private final IssueService issueService;

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

        //찬성인 경우
        if (isAgree) {
            issue.increaseAgreeCount();
        }

        //반대인 경우
        issue.increaseDisagreeCount();
    }

    public VoteInfoResponse getVoteInfo(Long userId, Long issueId) {
        User user = userService.getUser(userId);
        Issue issue = issueService.getIssue(userId, issueId);

        if(voteRepository.existsByUserAndIssue(user, issue)) {
            return VoteInfoResponse.of(user, issue, true, issue.getAgreeCount(), issue.getDisagreeCount());
        }

        return  VoteInfoResponse.of(user,issue, false);
    }

}
