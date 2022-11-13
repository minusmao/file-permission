package com.example.file.permission.common.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * 统一响应结果VO
 *
 * @author minus
 * @since 2022-11-13 14:04:16
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultVO<T> {

    private int code;
    private String msg;
    private T data;

    /* 类方法 */
    // 封装响应结果
    public static <T> ResultVO<T> result(int code, String msg, T data) {
        return new ResultVO<>(code, msg, data);
    }
    // 封装响应结果：成功（suc）
    public static <T> ResultVO<T> suc() {
        return suc(null);
    }
    public static <T> ResultVO<T> suc(T data) {
        return result(200, "操作成功", data);
    }
    // 封装响应结果：失败（fail）
    public static <T> ResultVO<T> fail(int code, String msg) {
        return fail(code, msg, null);
    }
    public static <T> ResultVO<T> fail(int code, String msg, T data) {
        return result(code, msg, data);
    }

}
