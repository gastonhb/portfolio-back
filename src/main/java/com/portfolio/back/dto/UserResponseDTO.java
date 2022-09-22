package com.portfolio.back.dto;

import com.portfolio.back.model.Person;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDTO {
    private UUID id;
    private String username;
    private String email;
    private Person person;

    public UserResponseDTO() {
    }

    public UserResponseDTO(UUID id, String username, String email, Person person) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.person = person;
    }
    
}



