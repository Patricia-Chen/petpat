package com.example.utils;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {
    private Integer code;
    private String desc;
    private T data;
/*    @JsonIgnore
    private int httpCode;*/

    public static Result setResult(ResultCodeEnum codeEnum){
        Result result = new Result();
        result.code = codeEnum.getCode();
        result.desc = codeEnum.getDesc();
        return result;
    }

    public static Result setResult(ErrorEnum errorEnum){
        Result result = new Result();
        result.code = errorEnum.getCode();
        result.desc = errorEnum.getDesc();
        return result;
    }


    public static <T> Result<T> success(T data){
        Result result = setResult(ResultCodeEnum.SUCCESS);
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(T data){
        Result result = setResult(ErrorEnum.UNKNOWN_ERROR);
        result.data = data;
        return result;
    }


}
