package com.soptkathonserverandroid2.domain.recommend.controller;

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
    @PostMapping("{issueId}")
    public ResponseEntity<SuccessResponse<Void>> createIssue(@RequestHeader Long userId, @PathVariable Long issueId) {

        return ResponseEntity
                .status(SUCCESS_CREATE.getHttpStatus().value())
                .body(SuccessResponse.of(SuccessCode.SUCCESS_CREATE));
    }
}
