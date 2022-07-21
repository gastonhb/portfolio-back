package com.portfolio.back.service;

import com.portfolio.back.model.Skill;
import com.portfolio.back.repository.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class SkillService extends BaseService<Skill> implements ISkillService{
    
    public SkillService(SkillRepository repository) {
        super(repository);
    }
}
