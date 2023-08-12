package com.truenorth.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtResponse {
    private String accessToken;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;

    public JwtResponse(String token,Long id, String username, String email) {
        this.accessToken = token;
        this.id = id;
        this.username = username;
        this.email = email;
    }
}