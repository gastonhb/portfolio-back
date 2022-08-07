package com.portfolio.back.dto;

import com.portfolio.back.model.Person;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponse {
    private UUID id;
    private String username;
    private String email;
    private Person person;

    public UserResponse() {
    }

    public UserResponse(UUID id, String username, String email, Person person) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.person = person;
    }
    
}



