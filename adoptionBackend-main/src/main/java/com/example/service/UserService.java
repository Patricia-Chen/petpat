package com.example.service;


import com.example.pojo.entity.UserEntity;
import com.example.pojo.vo.UserVO;

import java.util.List;

public interface UserService {
    boolean register(String userName,String password,String realName,Long IdCard,Long phoneNumber,String email);
    Long login(String username, String password);
    boolean update(String userName,String password,String realName,Long IdCard,Long phoneNumber,String email, String address);
    Long getId(UserVO userVO);
    UserVO getUserById(Long id);
}
