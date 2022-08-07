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
public class Person implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String lastname;
    private String title;
    private String abstracts;
    
    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;
    
    public Person() {   }

    public Person(UUID id, String name, String lastname, String title, String abstracts, Address address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.abstracts = abstracts;
        this.address = address;
    }

    public Person(String name, String lastname, String title, String abstracts, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.abstracts = abstracts;
        this.address = address;
    }

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    
}
