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
public class WorkExperience implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String title;
    private String companyName;
    private String startDate;
    private String endDate;
    private String workTime;
    private String location;
    
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    public WorkExperience() {}

    public WorkExperience(UUID id, String title, String companyName, String startDate, String endDate, String workTime, String location, Person person) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workTime = workTime;
        this.location = location;
        this.person = person;
    }

    public WorkExperience(String title, String companyName, String startDate, String endDate, String workTime, String location, Person person) {
        this.title = title;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workTime = workTime;
        this.location = location;
        this.person = person;
    }
    
    
    
}
