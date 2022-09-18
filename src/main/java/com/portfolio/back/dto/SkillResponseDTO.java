package com.portfolio.back.dto;

import com.portfolio.back.model.SkillType;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillResponseDTO {
    private UUID id;
    private String name;
    private Integer grade;
    private UUID personId;
    private UUID skillTypeId;
    private SkillType skillType;

    public SkillResponseDTO() {
    }

    public SkillResponseDTO(UUID id, String name, Integer grade, UUID personId, UUID skillTypeId, SkillType skillType) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.personId = personId;
        this.skillTypeId = skillTypeId;
        this.skillType = skillType;
    }
 
}
