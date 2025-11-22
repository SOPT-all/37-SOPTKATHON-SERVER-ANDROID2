package com.soptkathonserverandroid2.domain.issue.dto.response;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.issue.entity.enums.Range;
import com.soptkathonserverandroid2.domain.user.entity.enums.Department;

public record PassedIssueInfoResponse(
        Long id,
        String title,
        Range range,
        Department department,
        int votedCount,
        boolean isCouncil
) {
    public static PassedIssueInfoResponse from(Issue issue) {
        return new PassedIssueInfoResponse(
                issue.getId(),
                issue.getTitle(),
                issue.getRange(),
                issue.getDepartment(),
                issue.getAgreeCount() + issue.getDisagreeCount(),
                issue.isCouncil()
        );
    }
}
