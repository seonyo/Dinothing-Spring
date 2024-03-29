package com.example.Dinothing.controller;

import com.example.Dinothing.dto.LoginDto;
import com.example.Dinothing.dto.PasswordUpdateDto;
import com.example.Dinothing.dto.RegisterDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private HttpServletRequest httpRequest;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping()
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto request) {
        UserEntity users = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입에 성공했습니다");
    }

    @PostMapping("/login")
    public ResponseEntity<Long> loginUser(@RequestBody LoginDto request){
        long id = userService.loginUser(request, httpRequest);
        return ResponseEntity.ok().body(id);
    }

    @PatchMapping("/password")
    public ResponseEntity<String> passwrodUpdateUser(@RequestBody PasswordUpdateDto request){
        UserEntity newPassword = userService.passwordUpdate(request);
        return ResponseEntity.ok().body("비밀번호 변경에 성공했습니다");
    }
}
