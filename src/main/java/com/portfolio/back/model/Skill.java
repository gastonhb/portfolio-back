package com.portfolio.back.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter @Setter
@Entity
public class Skill implements Serializable {
    
    // Revisar condiciones
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private Integer grade;
    
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;
    
    @ManyToOne
    @JoinColumn(name = "skillTypeId")
    private SkillType skillType;

    public Skill() {
    }

    public Skill(UUID id, String name, Integer grade, Person person, SkillType skillType) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.person = person;
        this.skillType = skillType;
    }

    public Skill(String name, Integer grade, Person person, SkillType skillType) {
        this.name = name;
        this.grade = grade;
        this.person = person;
        this.skillType = skillType;
    }

}
