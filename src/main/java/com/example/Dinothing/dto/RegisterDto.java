package com.example.Dinothing.dto;

import com.example.Dinothing.entity.UserEntity;
import lombok.Getter;

@Getter
public class RegisterDto {
    private String nickname;
    private String email;
    private String password;

    public UserEntity toEntity(String password) {
        return UserEntity.builder()
                .nickname(nickname)
                .email(email)
                .password(password)
                .build();
    }
}
