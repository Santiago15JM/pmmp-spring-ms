package com.ppyd.userservice.models.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String email;
    private String password;
}
