package com.portfolio.back.dto;

import java.util.UUID;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationRequestDTO {
    
    private UUID id;
    
    @NotBlank(message = "Title is required")
    private String title;
    
    @NotBlank(message = "Institute is required")
    private String institute;
    
    @Min(value = 1900, message = "StartDate should not be less than 1900")
    @Max(value = 2500, message = "StartDate should not be greater than 2500")
    @NotNull(message = "StartDate is required")
    private Number startDate;
    
    @Min(value = 1900, message = "StartDate should not be less than 1900")
    @Max(value = 2500, message = "StartDate should not be greater than 2500")
    private Number endDate;
    
    private String urlImage;
    
    @NotNull(message = "PersonId is required")
    private UUID personId;

    public EducationRequestDTO() {
    }
    
}
