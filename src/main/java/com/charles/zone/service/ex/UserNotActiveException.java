package com.charles.zone.service.ex;

public class UserNotActiveException extends ServiceException{
    public UserNotActiveException() {
        super();
    }

    public UserNotActiveException(String message) {
        super(message);
    }

    public UserNotActiveException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotActiveException(Throwable cause) {
        super(cause);
    }

    protected UserNotActiveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
