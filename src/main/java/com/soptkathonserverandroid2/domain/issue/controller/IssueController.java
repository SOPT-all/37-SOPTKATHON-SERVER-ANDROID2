package com.soptkathonserverandroid2.domain.issue.controller;

import java.util.List;

import com.soptkathonserverandroid2.domain.issue.dto.response.PassedIssueInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soptkathonserverandroid2.domain.issue.dto.response.IssueInfoResponse;
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

	@GetMapping("/best")
	public ResponseEntity<SuccessResponse<IssueInfoResponse>> getBestIssue() {
		IssueInfoResponse issueInfoResponse = issueService.getBestIssue();
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, issueInfoResponse));
	}

	@GetMapping
	public ResponseEntity<SuccessResponse<List<IssueInfoResponse>>> getIssueList(
		@RequestHeader Long userId,
		@RequestParam(defaultValue = "all") String range,
		@RequestParam(defaultValue = "recommend") String order
	){
		List<IssueInfoResponse> issueInfoResponseList = issueService.getIssueList(userId, range, order);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, issueInfoResponseList));
	}
    @PostMapping
    public ResponseEntity<SuccessResponse<Void>> createIssue(@RequestHeader Long userId, @RequestBody IssueCreateRequest req) {
        issueService.createIssue(userId, req.title(), req.description(), req.range());
        return ResponseEntity
                .status(SUCCESS_CREATE.getHttpStatus().value())
                .body(SuccessResponse.of(SuccessCode.SUCCESS_CREATE));
    }

    @GetMapping("/pass")
    public ResponseEntity<SuccessResponse<List<PassedIssueInfoResponse>>> getPassedIssueList(@RequestHeader Long userId) {
        List<PassedIssueInfoResponse> passedIssueList = issueService.getPassedIssueList(userId);
        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, passedIssueList));
    }
}
