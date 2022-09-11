package com.portfolio.back.service;

import com.portfolio.back.dto.SocialNetworkResponseDTO;
import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.SocialNetwork;
import com.portfolio.back.repository.SocialNetworkRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialNetworkService implements ISocialNetworkService {
    
    @Autowired
    public SocialNetworkRepository  repository;
    
    @Override
    public List<SocialNetworkResponseDTO> list() {
        List<SocialNetwork> socialNetworks = repository.findAll();
        return this.convertToListResponseDTO(socialNetworks);
    }

    @Override
    public SocialNetworkResponseDTO create(SocialNetwork socialNetwork) {
        SocialNetwork savedSocialNetwork = repository.save(socialNetwork);
        return this.convertToResponseDTO(savedSocialNetwork);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public SocialNetworkResponseDTO getById(UUID id) {
        SocialNetwork socialNetwork = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("SocialNetwork", "id", id));
        return this.convertToResponseDTO(socialNetwork);
    }
    
    @Override
    public SocialNetworkResponseDTO update(SocialNetwork socialNetwork) {
	SocialNetwork savedSocialNetwork = repository.save(socialNetwork);
        return this.convertToResponseDTO(savedSocialNetwork);
    }
    
    @Override
    public List<SocialNetworkResponseDTO> list(UUID personId) {
        List<SocialNetwork> socialNetworks = repository.findAllByPersonId(personId);
        return this.convertToListResponseDTO(socialNetworks);
    }
    
    private SocialNetworkResponseDTO convertToResponseDTO(SocialNetwork socialNetwork){
        SocialNetworkResponseDTO socialNetworkResponseDTO = new
            SocialNetworkResponseDTO(
                socialNetwork.getId(), 
                socialNetwork.getDescription(),
                socialNetwork.getPerson().getId(),
                socialNetwork.getSocialNetworkType().getId(),
                socialNetwork.getSocialNetworkType()
            );
        return socialNetworkResponseDTO;
    }
    
    private List<SocialNetworkResponseDTO> convertToListResponseDTO(List<SocialNetwork> socialNetworks){
        
        List<SocialNetworkResponseDTO> socialNetworksResponse = new ArrayList<>(); 
        for(SocialNetwork socialNetwork: socialNetworks){
            SocialNetworkResponseDTO socialNetworkResponseDTO = this.convertToResponseDTO(socialNetwork);
            socialNetworksResponse.add(socialNetworkResponseDTO);
        }
        return socialNetworksResponse;
    }
    
}
