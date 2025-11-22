package com.soptkathonserverandroid2.domain.issue.dto.request;

import com.soptkathonserverandroid2.domain.issue.entity.enums.Range;

public record IssueCreateRequest(
        String title,
        String description,
        Range range
) {
}
