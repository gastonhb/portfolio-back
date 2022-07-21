package com.portfolio.back.dto;


import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class WorkExperienceDTO {
    public UUID id;
    private String title;
    private String companyName;
    private String startDate;
    private String endDate;
    private String workTime;
    private String location;
    private UUID personId;

    public WorkExperienceDTO() {
    }
    
    
}
