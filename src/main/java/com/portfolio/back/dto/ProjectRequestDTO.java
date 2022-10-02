package com.portfolio.back.dto;

import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjectRequestDTO {
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private String description;
    
    @PastOrPresent(message = "StartDate should be in the past")
     private Date startDate;
    
    @PastOrPresent(message = "EndDate should be in the past")
    private Date endDate;
    
    @NotBlank(message = "Link is required")
    private String link;
    
    private String urlImage;
    
    @NotNull(message = "PersonId is required")
    private UUID personId;

    public ProjectRequestDTO() {
    }
    
}
