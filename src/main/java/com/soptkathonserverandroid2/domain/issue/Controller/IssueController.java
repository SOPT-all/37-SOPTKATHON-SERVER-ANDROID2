package com.soptkathonserverandroid2.domain.issue.Controller;

import com.soptkathonserverandroid2.domain.issue.dto.request.IssueCreateRequest;
import com.soptkathonserverandroid2.domain.issue.service.IssueService;
import com.soptkathonserverandroid2.global.exception.code.SuccessCode;
import com.soptkathonserverandroid2.global.exception.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.soptkathonserverandroid2.global.exception.code.SuccessCode.SUCCESS_CREATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/issues")
public class IssueController {

    private final IssueService issueService;

    @PostMapping
    public ResponseEntity<SuccessResponse<Void>> createIssue(@RequestHeader Long userId, @RequestBody IssueCreateRequest req) {
        issueService.createIssue(userId, req.title(), req.description(), req.range());
        return ResponseEntity
                .status(SUCCESS_CREATE.getHttpStatus().value())
                .body(SuccessResponse.of(SuccessCode.SUCCESS_CREATE));
    }
}
