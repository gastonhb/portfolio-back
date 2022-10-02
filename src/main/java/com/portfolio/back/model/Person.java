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
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String lastname;
    
    @Column(nullable = true)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = true)
    private String abstracts;
    
    @Column(columnDefinition = "TEXT", nullable = true)
    private String urlImage;
    
    @Column(columnDefinition = "TEXT", nullable = true)
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
