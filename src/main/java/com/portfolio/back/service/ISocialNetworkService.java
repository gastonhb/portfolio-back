package com.portfolio.back.service;

import com.portfolio.back.dto.SocialNetworkResponseDTO;
import com.portfolio.back.model.SocialNetwork;
import java.util.List;
import java.util.UUID;

public interface ISocialNetworkService {
    
    public List<SocialNetworkResponseDTO> list ();
    
    public SocialNetworkResponseDTO create (SocialNetwork socialNetwork);
    
    public void delete (UUID id);
    
    public SocialNetworkResponseDTO getById (UUID id);
    
    public SocialNetworkResponseDTO update (SocialNetwork socialNetwork);
    
    public List<SocialNetworkResponseDTO> list (UUID personId);
}
