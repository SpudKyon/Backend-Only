package com.dongdong.yx.common.result;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;

    private String message;
    private T data;

    private Result() {
    }

    public static <T> Result<T> build(T data, ResultEnum resultEnum) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        result.code = resultEnum.getCode();
        result.message = resultEnum.getMessage();
        return result;
    }

    public static <T> Result<T> build(T data, Integer code, String message) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        result.code = code;
        result.message = message;
        return result;
    }

    public static <T> Result<T> success(T data) {
        return build(data, ResultEnum.SUCCESS);
    }

    public static <T> Result<T> fail(T data) {
        return build(data, ResultEnum.FAIL);
    }

}
