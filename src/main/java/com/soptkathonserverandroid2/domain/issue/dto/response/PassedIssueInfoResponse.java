package com.soptkathonserverandroid2.domain.issue.dto.response;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;

public record PassedIssueInfoResponse(
        Long id,
        String title,
        String range,
        String department,
        int votedCount,
        boolean isCouncil
) {
    public static PassedIssueInfoResponse from(Issue issue) {
        return new PassedIssueInfoResponse(
                issue.getId(),
                issue.getTitle(),
                issue.getRange().getValue(),
                issue.getDepartment().getValue(),
                issue.getAgreeCount() + issue.getDisagreeCount(),
                issue.isCouncil()
        );
    }
}
