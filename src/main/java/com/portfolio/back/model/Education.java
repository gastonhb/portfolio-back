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
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter @Setter
@Entity
@Table(uniqueConstraints={
    @UniqueConstraint(columnNames = {"personId", "title", "institute"})
}) 
public class Education implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;
   
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String institute;
    
    @Column(nullable = false)
    private Number startDate;
    
    @Column(nullable = true)
    private Number endDate;
    
    @Column(columnDefinition = "TEXT", nullable = true)
    private String urlImage;
    
    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
    private Person person;

    public Education() {
    }

    public Education(UUID id, String title, String institute, Number startDate, Number endDate, String urlImage, Person person) {
        this.id = id;
        this.title = title;
        this.institute = institute;
        this.startDate = startDate;
        this.endDate = endDate;
        this.urlImage = urlImage;
        this.person = person;
    }

    public Education(String title, String institute, Number startDate, Number endDate, String urlImage, Person person) {
        this.title = title;
        this.institute = institute;
        this.startDate = startDate;
        this.endDate = endDate;
        this.urlImage = urlImage;
        this.person = person;
    }

}
