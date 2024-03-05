package com.example.controller;

import com.example.pojo.entity.UserEntity;
import com.example.pojo.vo.UserVO;
import com.example.utils.Result;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public boolean register(@RequestBody UserVO userVO){
        return userService.register(userVO.getUserName(),userVO.getPassword(),userVO.getRealName(),userVO.getIdCard(),userVO.getPhoneNumber(),userVO.getEmail());
    }

    @PostMapping("/login")
    public Long login(@RequestBody UserVO userVO) throws Exception {
        Long ret = userService.login(userVO.getUserName(), userVO.getPassword());
        if(ret==1){
            return userService.getId(userVO);
        }
        else {
            return ret;
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserVO> getUserById(@PathVariable Long userId) {
        // 根据userId获取用户信息
        UserVO user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/update")
    public Result<UserVO> update(@RequestBody UserVO userVO){
        boolean ret = userService.update(userVO.getUserName(),userVO.getPassword(),userVO.getRealName(),userVO.getIdCard(),userVO.getPhoneNumber(),userVO.getEmail(),userVO.getAddress());
        if(ret) return Result.success(userVO);
        return Result.error(userVO);
    }



}
