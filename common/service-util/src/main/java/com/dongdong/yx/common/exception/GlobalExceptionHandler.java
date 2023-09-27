package com.dongdong.yx.common.exception;

import com.dongdong.yx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler<T> {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<T> error(Exception e){
        e.printStackTrace();
        return Result.fail(null);
    }

    @ExceptionHandler(YxException.class)
    @ResponseBody
    public Result<T> error(YxException e) {
        return Result.build(null, e.getCode(), e.getMessage());
    }
}
