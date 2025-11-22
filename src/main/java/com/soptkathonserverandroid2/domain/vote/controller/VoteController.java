package com.soptkathonserverandroid2.domain.vote.controller;

import com.soptkathonserverandroid2.domain.vote.dto.request.VoteRequest;
import com.soptkathonserverandroid2.domain.vote.service.VoteService;
import com.soptkathonserverandroid2.global.exception.code.SuccessCode;
import com.soptkathonserverandroid2.global.exception.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.soptkathonserverandroid2.global.exception.code.SuccessCode.SUCCESS_CREATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/votes")
public class VoteController {

    private final VoteService voteService;

    @PostMapping("{issueId}")
    public ResponseEntity<SuccessResponse<Void>> createVote(@RequestHeader Long userId, @PathVariable Long issueId, @RequestBody VoteRequest req) {
        voteService.createVote(userId, issueId, req.isAgree());
        return ResponseEntity
                .status(SUCCESS_CREATE.getHttpStatus().value())
                .body(SuccessResponse.of(SuccessCode.SUCCESS_CREATE));
    }
}
