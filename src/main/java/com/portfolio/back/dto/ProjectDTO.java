package com.portfolio.back.dto;

import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjectDTO {
    private UUID id;
    private String name;
    private String description;
    private Date realizationDate;
    private String link;
    private UUID personId;

    public ProjectDTO() {
    }
    
}
