package org.math.exception;

import org.springframework.http.HttpStatus;

public class WrongValueException extends ResponseException {

    public WrongValueException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusError() {
        return HttpStatus.BAD_REQUEST;
    }
}
