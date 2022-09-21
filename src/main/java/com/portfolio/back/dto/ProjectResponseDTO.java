package com.portfolio.back.dto;

import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjectResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String link;
    private String urlImage;
    private UUID personId;

    public ProjectResponseDTO() {
    }

    public ProjectResponseDTO(UUID id, String name, String description, Date startDate, Date endDate, String link, String urlImage, UUID personId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.link = link;
        this.urlImage = urlImage;
        this.personId = personId;
    }
    
}
