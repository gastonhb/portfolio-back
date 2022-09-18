package com.portfolio.back.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillRequestDTO {
    private UUID id;
    private String name;
    private String type;
    private Integer grade;
    private UUID personId;
    private UUID skillTypeId;

    public SkillRequestDTO() {
    }

}
