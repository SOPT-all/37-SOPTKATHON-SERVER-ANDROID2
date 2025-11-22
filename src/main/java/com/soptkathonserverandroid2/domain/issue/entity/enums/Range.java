package com.soptkathonserverandroid2.domain.issue.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Range {
    ALL("전체"),
    DEPARTMENT("학과"),
    COLLEGE("단과대학");

    private String value;
}
