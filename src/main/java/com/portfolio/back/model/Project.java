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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter @Setter
@Entity
@Table(uniqueConstraints={
    @UniqueConstraint(columnNames = {"personId", "name"})
}) 
public class Project implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = true)
    private String description;
    
    @Column(nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    
    @Column(nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String link;
    
    @Column(columnDefinition = "TEXT", nullable = true)
    private String urlImage;
    
    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
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
