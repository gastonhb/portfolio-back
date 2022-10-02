package com.portfolio.back.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter @Setter
@Entity
public class SkillType implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Name is required")
    private String name;

    public SkillType() {
    }

    public SkillType(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    
}
