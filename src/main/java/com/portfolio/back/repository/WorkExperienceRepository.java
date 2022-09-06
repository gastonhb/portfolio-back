package com.portfolio.back.repository;

import com.portfolio.back.model.WorkExperience;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository <WorkExperience, UUID>{
    
    public List<WorkExperience> findAllByPersonId(UUID personId);
    
}
