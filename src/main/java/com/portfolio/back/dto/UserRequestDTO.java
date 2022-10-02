package com.portfolio.back.dto;

import java.util.UUID;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDTO {
    
    @NotBlank(message = "Username is required")
    private String username;
    
    @NotBlank(message = "Password is required")
    private String password;
    
    @Email(message = "Email is required")
    private String email;
    
    private UUID personId;
    
    private String name;
    
    private String lastname;

    public UserRequestDTO() {
    }
    
}
