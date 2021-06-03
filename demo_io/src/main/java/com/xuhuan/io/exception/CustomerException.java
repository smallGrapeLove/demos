package com.xuhuan.io.exception;

/**
 * @author huan.xu
 * @ClassName CustomerException
 * @date 2021/4/8 11:27
 * @Description 自定义异常
 */
public class CustomerException extends RuntimeException {

    private String code;

    public CustomerException() {
        super();
    }

    public CustomerException(String msg) {
        super(msg);
    }

    public CustomerException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
