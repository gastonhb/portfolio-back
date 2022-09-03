package com.portfolio.back.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthResponse {
    private String username;
    private String accessToken;
    private UUID personId;
 
    public AuthResponse() { }
     
    public AuthResponse(String username, String accessToken, UUID personId) {
        this.username = username;
        this.accessToken = accessToken;
        this.personId = personId;
    }
}
