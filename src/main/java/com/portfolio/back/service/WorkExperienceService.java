package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.WorkExperience;
import com.portfolio.back.repository.WorkExperienceRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceService implements IWorkExperienceService{
    
    @Autowired
    public WorkExperienceRepository  repository;
    
    @Override
    public List<WorkExperience> list() {
        return repository.findAll();
    }

    @Override
    public WorkExperience create(WorkExperience workExperience) {
        return repository.save(workExperience);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public WorkExperience getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("WorkExperience", "id", id));
    }
    
    @Override
    public WorkExperience update(WorkExperience workExperience) {
	return repository.save(workExperience);
    }

}
