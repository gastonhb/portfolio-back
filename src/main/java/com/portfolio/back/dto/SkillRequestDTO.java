package com.portfolio.back.dto;

import java.util.UUID;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;
    
    @PositiveOrZero(message = "Grade shoul not be negative")
    @Min(value = 0, message = "Grade should not be less than 0")
    @Max(value = 100, message = "Grade should not be greater than 100")
    private Integer grade;
    
    @NotNull(message = "PersonId is required")
    private UUID personId;
    
    @NotNull(message = "SkillTypeId is required")
    private UUID skillTypeId;

    public SkillRequestDTO() {
    }

}
