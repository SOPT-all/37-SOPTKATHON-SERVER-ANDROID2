package com.soptkathonserverandroid2.domain.vote.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.user.entity.User;
import com.soptkathonserverandroid2.domain.vote.entity.Vote;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record VoteInfoResponse(
	String title,
	String description,
	List<String> imageUrl,
	String college,
	String department,
	boolean isVoted,
	Boolean isAgree,
	Integer agreeCount,
	Integer disagreeCount
) {
	public static VoteInfoResponse of(User user, Issue issue, boolean isVoted) {
		return new VoteInfoResponse(
			issue.getTitle(),
			issue.getDescription(),
			issue.getImageUrls(),
			user.getCollege().getValue(),
			user.getDepartment().getValue(),
			isVoted,
			null,
			null,
			null
		);
	}

	public static VoteInfoResponse of(Vote vote, User user, Issue issue, boolean isVoted, int agreeCount, int disagreeCount) {
		return new VoteInfoResponse(
			issue.getTitle(),
			issue.getDescription(),
			issue.getImageUrls(),
			user.getCollege().getValue(),
			user.getDepartment().getValue(),
			isVoted,
			vote.getIsAgree(),
			issue.getAgreeCount(),
			issue.getDisagreeCount()
		);
	}
}
