package com.portfolio.back.dto;

import com.portfolio.back.model.WorkTimeType;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WorkExperienceResponseDTO {
    public UUID id;
    private String title;
    private String companyName;
    private Date startDate;
    private Date endDate;
    private String location;
    private String urlImage;
    private UUID personId;
    private UUID workTimeTypeId;
    private WorkTimeType workTimeType;

    public WorkExperienceResponseDTO(UUID id, String title, String companyName, Date startDate, Date endDate, String location, String urlImage, UUID personId, UUID workTimeTypeId, WorkTimeType workTimeType) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.urlImage = urlImage;
        this.personId = personId;
        this.workTimeTypeId = workTimeTypeId;
        this.workTimeType = workTimeType;
    }    

}
