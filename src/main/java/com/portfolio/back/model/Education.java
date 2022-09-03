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
public class Education implements Serializable {
    
    // Revisar condiciones
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    // @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String title;
    private String institute;
    private Integer startDate;
    private Integer endDate;
    @Column(columnDefinition = "TEXT")
    private String urlImage;
    
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    public Education() {
    }

    public Education(UUID id, String title, String institute, Integer startDate, Integer endDate, String urlImage, Person person) {
        this.id = id;
        this.title = title;
        this.institute = institute;
        this.startDate = startDate;
        this.endDate = endDate;
        this.urlImage = urlImage;
        this.person = person;
    }

    public Education(String title, String institute, Integer startDate, Integer endDate, String urlImage, Person person) {
        this.title = title;
        this.institute = institute;
        this.startDate = startDate;
        this.endDate = endDate;
        this.urlImage = urlImage;
        this.person = person;
    }

}
