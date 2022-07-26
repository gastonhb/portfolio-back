package com.portfolio.back.dto;

import com.portfolio.back.model.SocialNetworkType;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SocialNetworkResponseDTO {
    private UUID id;
    private String content;
    private UUID personId;
    private UUID socialNetworkTypeId;
    private SocialNetworkType socialNetworkType;

    public SocialNetworkResponseDTO() {
    }

    public SocialNetworkResponseDTO(UUID id, String content, UUID personId, UUID socialNetworkTypeId, SocialNetworkType socialNetworkType) {
        this.id = id;
        this.content = content;
        this.personId = personId;
        this.socialNetworkTypeId = socialNetworkTypeId;
        this.socialNetworkType = socialNetworkType;
    }
    
}
