package com.example.pojo.vo;

import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
@Data
@Builder
public class UserVO {
    private String userName;

    private String password;

    private String realName;

    private Long IdCard;

    private Long phoneNumber;

    private String email;

    private String address;
}
