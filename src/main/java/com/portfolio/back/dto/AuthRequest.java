package com.portfolio.back.dto;

//import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthRequest {
    //@NotNull
    private String username;
     
    //@NotNull
    private String password;

    public AuthRequest() {
    }
    
    
}
