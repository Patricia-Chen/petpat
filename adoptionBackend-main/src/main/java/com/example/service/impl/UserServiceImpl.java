package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.pojo.entity.UserEntity;
import com.example.pojo.vo.UserVO;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public boolean register(String userName, String password, String realName, Long IdCard, Long phoneNumber ,String email){
        UserEntity user = userDao.getByUserName(userName);

        if (user != null) {
            return false;
        } else {
            userDao.save(UserEntity.builder().userName(userName).password(password).realName(realName).IdCard(IdCard).phoneNumber(phoneNumber).email(email).build());
            return true;
        }
    }

    @Override
    public Long login(String userName, String password){
        UserEntity userEntity = userDao.getByUserName(userName);
        if(userEntity == null) {
            return (long) -1;
        }
        String realPassword = userEntity.getPassword();
        if(password.equals(realPassword)) {
            return 1L;
        }
        else {
            return 0L;
        }
    }

    @Override
    public boolean update(String userName, String password, String realName, Long IdCard, Long phoneNumber ,String email, String address){
        UserEntity userEntity = userDao.getByUserName(userName);
        userEntity.setPassword(password);
        userEntity.setRealName(realName);
        userEntity.setIdCard(IdCard);
        userEntity.setPhoneNumber(phoneNumber);
        userEntity.setEmail(email);
        return true;
    }

    @Override
    public Long getId(UserVO userVO){
        return userDao.getByUserName(userVO.getUserName()).getId();
    }

    @Override
    public UserVO getUserById(Long id) {
        UserEntity user = userDao.getById(id);
        return UserVO.builder()
                .userName(user.getUserName())
                .password(user.getPassword())
                .realName(user.getRealName())
                .IdCard(user.getIdCard())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .address(user.getAddress())
                .build();
    }
}
