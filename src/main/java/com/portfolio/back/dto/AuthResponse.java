package com.portfolio.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthResponse {
    private String username;
    private String accessToken;
 
    public AuthResponse() { }
     
    public AuthResponse(String username, String accessToken) {
        this.username = username;
        this.accessToken = accessToken;
    }
}
