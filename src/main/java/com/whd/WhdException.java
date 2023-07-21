package com.whd;

/**
 *
 * @author vikramp
 */
public class WhdException extends Exception {
    WhdExceptionType exceptionType = null;
    String comment;
    
    public WhdException(String message) {
        super(message);
        comment = message;
    }

    public WhdException(WhdExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
    
    public WhdException(WhdExceptionType exceptionType, String message) {
        super(message);
        comment = message;
        this.exceptionType = exceptionType;
    }
    
    public WhdException(String message, Throwable throwable) {
        super(message, throwable);
        comment = message;
    }
    
    public WhdException(WhdExceptionType exceptionType, String message, Throwable throwable) {
        super(message, throwable);
        comment = message;
        this.exceptionType = exceptionType;
    }
    
    public WhdException(Throwable throwable) {
        super(throwable);
    }

    public WhdExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(WhdExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
}
