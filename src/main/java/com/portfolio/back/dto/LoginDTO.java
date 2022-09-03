package com.portfolio.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginDTO {
    // TODO revisar si se usa
    private String username;
    private String password;

    public LoginDTO() {
    }
    
}
