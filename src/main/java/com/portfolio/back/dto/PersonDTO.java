package com.portfolio.back.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonDTO {
    private UUID id;
    private String name;
    private String lastname;
    private String title;
    private String abstracts;
    private String urlImage;
    private String urlCoverPhoto;


    public PersonDTO() {
    }
    
}
