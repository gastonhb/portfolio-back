package com.portfolio.back.service;

import com.portfolio.back.model.Skill;
import java.util.List;
import java.util.UUID;

public interface ISkillService {
    
    public List<Skill> list ();
    
    public Skill create (Skill skill);
    
    public void delete (UUID id);
    
    public Skill getById (UUID id);
    
    public Skill update (Skill skill);
}
