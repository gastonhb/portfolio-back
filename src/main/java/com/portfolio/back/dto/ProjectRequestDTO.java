package com.portfolio.back.dto;

import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjectRequestDTO {
    private UUID id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String link;
    private String urlImage;
    private UUID personId;

    public ProjectRequestDTO() {
    }
    
}
