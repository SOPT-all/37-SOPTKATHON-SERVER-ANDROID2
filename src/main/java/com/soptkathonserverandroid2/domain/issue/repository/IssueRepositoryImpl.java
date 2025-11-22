package com.soptkathonserverandroid2.domain.issue.repository;

import static com.soptkathonserverandroid2.domain.issue.entity.QIssue.*;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.user.entity.enums.College;
import com.soptkathonserverandroid2.domain.user.entity.enums.Department;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class IssueRepositoryImpl implements IssueCustomRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Issue> findAllByRangeWithSort(String order,
		String range,
		College userCollege,
		Department userDepartment){
		return queryFactory
			.selectFrom(issue)
			.where(
				visibilityFilter(range, userCollege, userDepartment),
				notPassed()
			)
			.orderBy(sort(order))
			.fetch();

	}

	private BooleanExpression visibilityFilter(String range,
		College userCollege,
		Department userDepartment) {
		if("all".equalsIgnoreCase(range)){
			return null;
		}
		BooleanExpression collegeMatch =
			issue.college.eq(userCollege);

		BooleanExpression departmentMatch =
			issue.department.eq(userDepartment);

		return collegeMatch.or(departmentMatch);
	}

	private BooleanExpression notPassed() {
		return issue.isPassed.eq(false);
	}

	private OrderSpecifier<?> sort(String order) {
		if (order == null) {
			return issue.id.desc();
		}

		return switch (order.toLowerCase()){
			case "recommend" -> issue.recommendCount.desc();
			case "recent" -> issue.createdAt.desc();
			default -> issue.recommendCount.desc();
		};
	}

}
