package com.portfolio.back.dto;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SocialNetworkRequestDTO {

    @NotBlank(message = "Content is required")
    private String content;
    
    @NotNull(message = "PersonId is required")
    private UUID personId;
    
    @NotNull(message = "socialNetworkTypeId is required")
    private UUID socialNetworkTypeId;

    public SocialNetworkRequestDTO() {
    }

}
