package com.ideastack.cafe_management_backend.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String username;

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    private String password;
}
