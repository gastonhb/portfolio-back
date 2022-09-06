package com.portfolio.back.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WorkTimeTypeDTO {
    private UUID id;
    private String name;

    public WorkTimeTypeDTO() {
    }
    
}
