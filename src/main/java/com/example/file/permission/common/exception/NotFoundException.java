package com.example.file.permission.common.exception;

/**
 *
 * 资源未找到异常
 *
 * @author minus
 * @since 2022-11-13 14:04:16
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
