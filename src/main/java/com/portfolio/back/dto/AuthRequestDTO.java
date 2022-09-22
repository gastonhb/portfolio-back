package com.portfolio.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthRequestDTO {
    // TODO ver que sii se usa y decomentar null
    //@NotNull
    private String username;
     
    //@NotNull
    private String password;

    public AuthRequestDTO() {
    }
    
    
}
