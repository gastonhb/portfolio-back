package com.portfolio.back.service;


import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.Skill;
import com.portfolio.back.repository.SkillRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    
    @Autowired
    public SkillRepository  repository;
    
    @Override
    public List<Skill> list() {
        return repository.findAll();
    }

    @Override
    public Skill create(Skill skill) {
        return repository.save(skill);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Skill getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));
    }
    
    @Override
    public Skill update(Skill skill) {
	return repository.save(skill);
    }
}
