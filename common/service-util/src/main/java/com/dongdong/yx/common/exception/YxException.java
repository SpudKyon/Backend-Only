package com.dongdong.yx.common.exception;

import com.dongdong.yx.common.result.ResultEnum;
import lombok.Data;

@Data
public class YxException extends RuntimeException {
    private final Integer code;

    public YxException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public YxException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    @Override
    public String toString() {
        return "YxException{" +
                "code=" + code +
                "message=" + this.getMessage() +
                '}';
    }
}
