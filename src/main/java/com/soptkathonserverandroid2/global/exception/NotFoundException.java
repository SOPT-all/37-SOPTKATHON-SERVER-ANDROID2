package com.soptkathonserverandroid2.global.exception;

import com.soptkathonserverandroid2.global.exception.code.ErrorCode;

public class NotFoundException extends BusinessException {
    public NotFoundException(final ErrorCode errorCode) {
        super(errorCode);
    }
}
