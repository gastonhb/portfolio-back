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
    
    // Revisar condiciones
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    @Column(columnDefinition = "TEXT")
    private String link;
    @Column(columnDefinition = "TEXT")
    private String urlImage;
    
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    public Project() {
    }

    public Project(UUID id, String name, String description, Date startDate, Date endDate, String link, String urlImage, Person person) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.link = link;
        this.urlImage = urlImage;
        this.person = person;
    }

    public Project(String name, String description, Date startDate, Date endDate, String link, String urlImage, Person person) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.link = link;
        this.urlImage = urlImage;
        this.person = person;
    }
    
    
    
}
