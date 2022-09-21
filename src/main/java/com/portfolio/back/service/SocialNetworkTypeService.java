package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.SocialNetworkType;
import com.portfolio.back.repository.SocialNetworkTypeRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialNetworkTypeService implements ISocialNetworkTypeService {
    
    @Autowired
    public SocialNetworkTypeRepository  repository;
    
    @Override
    public List<SocialNetworkType> list() {
        return repository.findAllByOrderByNameAscIdAsc();
    }

    @Override
    public SocialNetworkType create(SocialNetworkType socialNetworkType) {
        return repository.save(socialNetworkType);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public SocialNetworkType getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("SocialNetworkType", "id", id));
    }
    
    @Override
    public SocialNetworkType update(SocialNetworkType socialNetworkType) {
	return repository.save(socialNetworkType);
    }
    
}
