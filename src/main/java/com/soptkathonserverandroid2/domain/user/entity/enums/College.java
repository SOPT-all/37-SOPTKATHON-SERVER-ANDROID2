package com.soptkathonserverandroid2.domain.user.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum College {
    ART("미술대학"),
    ENGINEERING("공과대학"),
    BUSINESS("경영대학"),
    COUNCIL("학생회");
    String value;
}
