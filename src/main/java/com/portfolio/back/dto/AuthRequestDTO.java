package com.portfolio.back.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthRequestDTO {
    
    @NotBlank(message = "Username is required")
    private String username;
     
    @NotBlank(message = "Password is required")
    private String password;

    public AuthRequestDTO() {
    }
    
}
