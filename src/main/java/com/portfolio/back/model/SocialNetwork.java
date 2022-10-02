package com.portfolio.back.model;

import java.io.Serializable;
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
    @UniqueConstraint(columnNames = {"personId", "content", "socialNetworkTypeId"})
}) 
public class SocialNetwork implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
    private Person person;
    
    @ManyToOne
    @JoinColumn(name = "socialNetworkTypeId", nullable = false)
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
