package com.portfolio.back.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter @Setter
@Entity
@Table(uniqueConstraints={
    @UniqueConstraint(columnNames = {"personId", "name"})
}) 
public class Skill implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Integer grade;
    
    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
    private Person person;
    
    @ManyToOne
    @JoinColumn(name = "skillTypeId", nullable = false)
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
