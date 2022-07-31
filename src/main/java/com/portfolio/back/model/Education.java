package com.portfolio.back.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.persistence.annotations.UuidGenerator;
import org.hibernate.annotations.GenericGenerator;

@Getter @Setter
@Entity
public class Education implements Serializable {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    // @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String title;
    private String institute;
    private Date startDate;
    private Date endDate;
    
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    public Education() {
    }

    public Education(UUID id, String title, String institute, Date startDate, Date endDate, Person person) {
        this.id = id;
        this.title = title;
        this.institute = institute;
        this.startDate = startDate;
        this.endDate = endDate;
        this.person = person;
    }

    public Education(String title, String institute, Date startDate, Date endDate, Person person) {
        this.title = title;
        this.institute = institute;
        this.startDate = startDate;
        this.endDate = endDate;
        this.person = person;
    }

}
