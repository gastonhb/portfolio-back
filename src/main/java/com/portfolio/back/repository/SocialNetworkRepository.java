package com.portfolio.back.repository;

import com.portfolio.back.model.SocialNetwork;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkRepository extends JpaRepository <SocialNetwork, UUID>{
    
    public List<SocialNetwork> findAllByPersonId(UUID personId);
    
}
