package io.dragon.depay.exception;

public class DepaySDKException extends Exception {
    public DepaySDKException(String message) { super(message); }
    public DepaySDKException(String message, Throwable cause) { super(message, cause); }
}
