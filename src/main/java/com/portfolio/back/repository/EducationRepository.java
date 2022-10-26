package com.portfolio.back.repository;

import com.portfolio.back.model.Education;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository <Education, UUID>{
    
    public List<Education> findAllByPersonIdOrderByStartDateDescIdAsc(UUID personId);
}
