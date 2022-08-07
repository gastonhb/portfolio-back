package com.portfolio.back.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private UUID personId;
    private String name;
    private String lastname;

    public UserDTO() {
    }
    
}
