package io.dragon.depay.model;

import io.dragon.depay.constant.Constant;

public class DepayResponse<T> {
    public int code;
    public String msg;
    public String ui;
    public String version;
    public int count;
    public T data;

    public DepayResponse<T> version(String v) {
        this.version=v;
        return this;
    }

    public DepayResponse<T> success() {
        this.code = Constant.CODE_SUCCESS;
        this.msg =Constant.MSG_SUCCESS;
        return this;
    }

    public DepayResponse<T> fail() {
        this.code = Constant.CODE_FAILED;
        this.msg =Constant.MSG_FAILED;
        return this;
    }

    public DepayResponse<T> fail(String msg) {
        this.code = Constant.CODE_FAILED;
        this.msg =msg;
        return this;
    }

    public DepayResponse<T> exception() {
        this.code = Constant.CODE_EXCEPTION;
        this.msg =Constant.MSG_EXCEPTION;
        return this;
    }

    public DepayResponse<T> exception(String msg) {
        this.code = Constant.CODE_FAILED;
        this.msg =msg;
        return this;
    }

    public DepayResponse<T> unauthorized() {
        this.code = Constant.CODE_UNAUTHORIZED;
        this.msg =Constant.MSG_UNAUTHORIZED;
        return this;
    }

    public DepayResponse<T> unauthorized(String msg) {
        this.code = Constant.CODE_UNAUTHORIZED;
        this.msg =msg;
        return this;
    }

    public DepayResponse<T> unauthenticated() {
        this.code = Constant.CODE_UNAUTHENTICATED;
        this.msg =Constant.MSG_UNAUTHENTICATED;
        return this;
    }

    public DepayResponse<T> unauthenticated(String msg) {
        this.code = Constant.CODE_UNAUTHENTICATED;
        this.msg =msg;
        return this;
    }

    public DepayResponse<T> data(T data) {
        this.data=data;
        return this;
    }

    public DepayResponse<T> data(T data, int count) {
        this.data=data;
        this.count=count;
        return this;
    }
}
