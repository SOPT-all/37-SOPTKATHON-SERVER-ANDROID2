package com.soptkathonserverandroid2.global.exception;

import com.soptkathonserverandroid2.global.exception.code.ErrorCode;

public class InvalidValueException extends BusinessException {
    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
