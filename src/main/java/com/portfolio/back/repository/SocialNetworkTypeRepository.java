package com.portfolio.back.repository;

import com.portfolio.back.model.SocialNetworkType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkTypeRepository extends JpaRepository <SocialNetworkType, UUID>{
    
}
