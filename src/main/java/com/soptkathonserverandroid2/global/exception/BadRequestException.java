package com.soptkathonserverandroid2.global.exception;

import com.soptkathonserverandroid2.global.exception.code.ErrorCode;

public class BadRequestException extends BusinessException {

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}

