package com.soptkathonserverandroid2.global.exception;

import com.soptkathonserverandroid2.global.exception.code.ErrorCode;

public class ForbiddenException extends BusinessException {
    public ForbiddenException(ErrorCode errorCode) {
        super(errorCode);
    }
}

