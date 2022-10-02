package com.portfolio.back.dto;

import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationResponseDTO {
    private UUID id;
    private String title;
    private String institute;
    private Date startDate;
    private Date endDate;
    private String urlImage;
    private UUID personId;

    public EducationResponseDTO() {
    }

    public EducationResponseDTO(UUID id, String title, String institute, Date startDate, Date endDate, String urlImage, UUID personId) {
        this.id = id;
        this.title = title;
        this.institute = institute;
        this.startDate = startDate;
        this.endDate = endDate;
        this.urlImage = urlImage;
        this.personId = personId;
    }
    
}
