package com.portfolio.back.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonRequestDTO {
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotBlank(message = "Lastname is required")
    private String lastname;
    
    private String title;
    
    private String abstracts;
    
    private String urlImage;
    
    private String urlCoverPhoto;

    public PersonRequestDTO() {
    }
    
}
