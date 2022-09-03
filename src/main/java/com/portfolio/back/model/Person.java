package com.portfolio.back.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter @Setter
@Entity
public class Person implements Serializable {
    
    // Revisar condiciones
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String lastname;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String abstracts;
    @Column(columnDefinition = "TEXT")
    private String urlImage;
    @Column(columnDefinition = "TEXT")
    private String urlCoverPhoto;
    
    public Person() {   }

    public Person(UUID id, String name, String lastname, String title, String abstracts, String urlImage, String urlCoverPhoto) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.abstracts = abstracts;
        this.urlImage = urlImage;
        this.urlCoverPhoto = urlCoverPhoto;
    }

    public Person(String name, String lastname, String title, String abstracts, String urlImage, String urlCoverPhoto) {
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.abstracts = abstracts;
        this.urlImage = urlImage;
        this.urlCoverPhoto = urlCoverPhoto;
    }

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    
}
