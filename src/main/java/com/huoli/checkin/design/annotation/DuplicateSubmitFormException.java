package com.huoli.checkin.design.annotation;

/**
 * 表单重复提交异常
 * User: Alec
 * Date: 13-3-15
 * Time: 下午2:49
 */
public class DuplicateSubmitFormException extends RuntimeException {

    /** */
    private static final long serialVersionUID = 8842077975703386160L;
    private String message;

    public DuplicateSubmitFormException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}