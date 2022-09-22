package com.portfolio.back.dto;


import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class WorkExperienceRequestDTO {
    public UUID id;
    private String title;
    private String companyName;
    private Date startDate;
    private Date endDate;
    private String location;
    private String urlImage;
    private UUID personId;
    private UUID workTimeTypeId;

    public WorkExperienceRequestDTO() {
    }
    
    
}
