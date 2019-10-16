package com.infy.tdd.training.exception;

/**
 * Created by EQS on 8/2/2018.
 */
public class NameNotFoundException extends Exception {

    private int errCode;

    public NameNotFoundException(int errCode, String message) {
        super(message);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
