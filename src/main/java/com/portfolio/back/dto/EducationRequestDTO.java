package com.portfolio.back.dto;

import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationRequestDTO {
    
    private UUID id;
    
    @NotBlank(message = "Title is required")
    private String title;
    
    @NotBlank(message = "Institute is required")
    private String institute;
    
    @PastOrPresent(message = "StartDate should be in the past")
    private Date startDate;
    
    @PastOrPresent(message = "EndDate should be in the past")
    private Date endDate;
    
    private String urlImage;
    
    @NotNull(message = "PersonId is required")
    private UUID personId;

    public EducationRequestDTO() {
    }
    
}
