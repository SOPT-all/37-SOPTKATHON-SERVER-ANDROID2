package com.soptkathonserverandroid2.domain.recommend.controller;

import com.soptkathonserverandroid2.domain.recommend.service.RecommendService;
import com.soptkathonserverandroid2.domain.vote.dto.request.VoteRequest;
import com.soptkathonserverandroid2.global.exception.code.SuccessCode;
import com.soptkathonserverandroid2.global.exception.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.soptkathonserverandroid2.global.exception.code.SuccessCode.SUCCESS_CREATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/recommends")
public class RecommendController {

    private final RecommendService recommendService;

    @PostMapping("{issueId}")
    public ResponseEntity<SuccessResponse<Void>> createRecommend(@RequestHeader Long userId, @PathVariable Long issueId) {
        recommendService.createRecommend(userId, issueId);
        return ResponseEntity
                .status(SUCCESS_CREATE.getHttpStatus().value())
                .body(SuccessResponse.of(SuccessCode.SUCCESS_CREATE));
    }
}
