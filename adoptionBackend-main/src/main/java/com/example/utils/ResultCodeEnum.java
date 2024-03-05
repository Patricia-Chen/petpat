package com.example.utils;


import lombok.Getter;

//https://juejin.cn/post/7261789163589845047
//https://blog.csdn.net/weixin_45973634/article/details/105385631
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "Success"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted");

    private Integer code;
    private String desc;

    ResultCodeEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
