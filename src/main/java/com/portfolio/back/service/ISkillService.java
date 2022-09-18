package com.portfolio.back.service;

import com.portfolio.back.dto.SkillResponseDTO;
import com.portfolio.back.model.Skill;
import java.util.List;
import java.util.UUID;

public interface ISkillService {
    
    public List<SkillResponseDTO> list ();
    
    public SkillResponseDTO create (Skill skill);
    
    public void delete (UUID id);
    
    public SkillResponseDTO getById (UUID id);
    
    public SkillResponseDTO update (Skill skill);
    
     public List<SkillResponseDTO> list (UUID personId);
}
