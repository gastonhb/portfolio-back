package com.portfolio.back.model;

import java.io.Serializable;
import java.util.Date;
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
public class Project implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String description;
    private Date realizationDate;
    private String link;
    
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    public Project() {
    }

    public Project(UUID id, String name, String description, Date realizationDate, String link, Person person) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.realizationDate = realizationDate;
        this.link = link;
        this.person = person;
    }

    public Project(String name, String description, Date realizationDate, String link, Person person) {
        this.name = name;
        this.description = description;
        this.realizationDate = realizationDate;
        this.link = link;
        this.person = person;
    }
    
}
