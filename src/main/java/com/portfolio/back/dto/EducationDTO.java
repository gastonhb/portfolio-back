package com.portfolio.back.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationDTO {
    private UUID id;
    private String title;
    private String institute;
    private Integer startDate;
    private Integer endDate;
    private String urlImage;
    private UUID personId;

    public EducationDTO() {
    }
    
    
}
