package com.example.dao;

import com.example.pojo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Long> {
    UserEntity getByUserName(String userName);
    UserEntity getById(Long id);
}
