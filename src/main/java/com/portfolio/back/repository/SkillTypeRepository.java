package com.portfolio.back.repository;

import com.portfolio.back.model.SkillType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SkillTypeRepository extends JpaRepository <SkillType, UUID>{
    
}
