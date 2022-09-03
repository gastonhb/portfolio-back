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
public class Skill implements Serializable{
    
    // Revisar condiciones
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String type;
    private Integer grade;
     
    
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    public Skill() {
    }

    public Skill(UUID id, String name, String type, Integer grade, Person person) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.grade = grade;
        this.person = person;
    }

    public Skill(String name, String type, Integer grade, Person person) {
        this.name = name;
        this.type = type;
        this.grade = grade;
        this.person = person;
    }

}
