package com.example.Dinothing.controller;

import com.example.Dinothing.dto.user.LoginRequestDto;
import com.example.Dinothing.dto.user.PasswordUpdateRequestDto;
import com.example.Dinothing.dto.user.RegisterRequestDto;
import com.example.Dinothing.dto.user.UserIdResponseDto;
import com.example.Dinothing.entity.UserEntity;
import com.example.Dinothing.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequestDto request) {
        UserEntity users = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입에 성공했습니다");
    }

    @PostMapping("/login")
    public ResponseEntity<UserIdResponseDto> loginUser(@RequestBody LoginRequestDto request){
        Long id = userService.loginUser(request, httpRequest);
        return ResponseEntity.ok().body(new UserIdResponseDto(id));
    }

    @PatchMapping("/password")
    public ResponseEntity<String> passwrodUpdateUser(@RequestBody PasswordUpdateRequestDto request){
        UserEntity newPassword = userService.passwordUpdate(request);
        return ResponseEntity.ok().body("비밀번호 변경에 성공했습니다");
    }
}
