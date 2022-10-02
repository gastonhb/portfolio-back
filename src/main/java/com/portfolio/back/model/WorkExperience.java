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
    @UniqueConstraint(columnNames = {"personId", "title", "companyName", "startDate"})
}) 
public class WorkExperience implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String companyName;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    
    @Column(nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    
    @Column(nullable = true)
    private String location;
    
    @Column(columnDefinition = "TEXT", nullable = true)
    private String urlImage;
    
    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
    private Person person;
    
    @ManyToOne
    @JoinColumn(name = "workTimeTypeId", nullable = false)
    private WorkTimeType workTimeType;

    public WorkExperience() {}

    public WorkExperience(UUID id, String title, String companyName, Date startDate, Date endDate, String location, String urlImage, Person person, WorkTimeType workTimeType) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.urlImage = urlImage;
        this.person = person;
        this.workTimeType = workTimeType;
    }

    public WorkExperience(String title, String companyName, Date startDate, Date endDate, String location, String urlImage, Person person, WorkTimeType workTimeType) {
        this.title = title;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.urlImage = urlImage;
        this.person = person;
        this.workTimeType = workTimeType;
    }
    
}
