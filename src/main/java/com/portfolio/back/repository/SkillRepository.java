package com.portfolio.back.repository;

import com.portfolio.back.model.Skill;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository <Skill, UUID>{
    
    public List<Skill> findAllByPersonId(UUID personId);
}
