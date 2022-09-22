package com.portfolio.back.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthResponseDTO {
    private String username;
    private String accessToken;
    private UUID personId;
 
    public AuthResponseDTO() { }
     
    public AuthResponseDTO(String username, String accessToken, UUID personId) {
        this.username = username;
        this.accessToken = accessToken;
        this.personId = personId;
    }
}
