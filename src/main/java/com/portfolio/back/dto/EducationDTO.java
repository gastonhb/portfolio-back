package com.portfolio.back.dto;

import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationDTO {
    private UUID id;
    private String title;
    private String institute;
    private Date startDate;
    private Date endDate;
    private UUID personId;

    public EducationDTO() {
    }
    
    
}
