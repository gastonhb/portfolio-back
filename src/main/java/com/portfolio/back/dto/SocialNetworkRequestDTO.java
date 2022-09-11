package com.portfolio.back.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SocialNetworkRequestDTO {
    private UUID id;
    private String description;
    private UUID personId;
    private UUID socialNetworkTypeId;

    public SocialNetworkRequestDTO() {
    }

}
