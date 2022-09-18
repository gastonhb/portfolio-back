package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.SkillType;
import com.portfolio.back.repository.SkillTypeRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillTypeService implements ISkillTypeService {
    
    @Autowired
    public SkillTypeRepository  repository;
    
    @Override
    public List<SkillType> list() {
        return repository.findAll();
    }

    @Override
    public SkillType create(SkillType skillType) {
        return repository.save(skillType);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public SkillType getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("SkillType", "id", id));
    }
    
    @Override
    public SkillType update(SkillType skillType) {
	return repository.save(skillType);
    }
    
}
