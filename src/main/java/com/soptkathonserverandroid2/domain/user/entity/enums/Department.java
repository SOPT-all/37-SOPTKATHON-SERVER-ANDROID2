package com.soptkathonserverandroid2.domain.user.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Department {
    DESIGN("시각디자인학과"),
    FINEART("회화학과"),
    SOFTWARE("컴퓨터공학과"),
    INDUSTRIAL("산업공학과"),
    BUSINESS("경영학과"),
    COUNCIL("학생회");

    private final String value;
}
