package com.soptkathonserverandroid2.domain.issue.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.soptkathonserverandroid2.domain.issue.entity.Issue;
import com.soptkathonserverandroid2.domain.user.entity.enums.College;
import com.soptkathonserverandroid2.domain.user.entity.enums.Department;


public interface IssueCustomRepository {
	List<Issue> findAllByRangeWithSort(String order,
		String range,
		College userCollege,
		Department userDepartment);
}

