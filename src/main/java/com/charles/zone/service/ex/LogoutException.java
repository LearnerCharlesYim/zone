package com.charles.zone.service.ex;

public class LogoutException extends ServiceException{
    public LogoutException() {
        super();
    }

    public LogoutException(String message) {
        super(message);
    }

    public LogoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogoutException(Throwable cause) {
        super(cause);
    }

    protected LogoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
