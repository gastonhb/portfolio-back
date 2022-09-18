package com.portfolio.back.service;

import com.portfolio.back.model.SkillType;
import java.util.List;
import java.util.UUID;


public interface ISkillTypeService {
    
    public List<SkillType> list ();
    
    public SkillType create (SkillType skillType);
    
    public void delete (UUID id);
    
    public SkillType getById (UUID id);
    
    public SkillType update (SkillType skillType);
}
