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
public class SocialNetwork implements Serializable {
    // Revisar condiciones
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(columnDefinition = "TEXT")
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;
    
    @ManyToOne
    @JoinColumn(name = "socialNetworkTypeId")
    private SocialNetworkType socialNetworkType;

    public SocialNetwork() {
    }

    public SocialNetwork(UUID id, String content, Person person, SocialNetworkType socialNetworkType) {
        this.id = id;
        this.content = content;
        this.person = person;
        this.socialNetworkType = socialNetworkType;
    }

    public SocialNetwork(String content, Person person, SocialNetworkType socialNetworkType) {
        this.content = content;
        this.person = person;
        this.socialNetworkType = socialNetworkType;
    }
    
}
