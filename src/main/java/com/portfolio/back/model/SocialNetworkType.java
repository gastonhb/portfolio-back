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
public class SocialNetworkType implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(nullable = false)
    private Boolean isLink;

    public SocialNetworkType() {
    }

    public SocialNetworkType(UUID id, String name, Boolean isLink) {
        this.id = id;
        this.name = name;
        this.isLink = isLink;
    }

    public SocialNetworkType(String name, Boolean isLink) {
        this.name = name;
        this.isLink = isLink;
    }   
    
}
