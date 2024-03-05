package com.example.utils;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    UNKNOWN_ERROR(500, "Unknown Error");

    private Integer code;
    private String desc;

    ErrorEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
