package com.soptkathonserverandroid2.domain.issue.dto.response;

import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.user.entity.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record IssueInfoResponse(
	String title,
	String college,
	Integer recommendCount,
	String range,
	String department,
	int remainedDay,
	Boolean isBest
	) {
	public static IssueInfoResponse of(Issue issue, User user, int remainedDay, boolean isBest) {
		return new IssueInfoResponse(
			issue.getTitle(),
			issue.getCollege().getValue(),
			issue.getRecommendCount(),
			issue.getRange().getValue(),
			user.getCollege().getValue(),
			remainedDay,
			false
		);
	}

	public static IssueInfoResponse of(Issue issue, User user, int remainedDay) {
		return new IssueInfoResponse(
			issue.getTitle(),
			issue.getCollege().getValue(),
			null,
			issue.getRange().getValue(),
			user.getCollege().getValue(),
			remainedDay,
			true
		);
	}
}
