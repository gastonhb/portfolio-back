package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.Education;
import com.portfolio.back.repository.EducationRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{
@Autowired
    public EducationRepository  repository;
    
    @Override
    public List<Education> list() {
        return repository.findAll();
    }

    @Override
    public Education create(Education education) {
        return repository.save(education);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Education getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Education", "id", id));
    }
    
    @Override
    public Education update(Education education) {
	return repository.save(education);
    }

    @Override
    public List<Education> list(UUID personId) {
        return repository.findAllByPersonIdOrderByStartDateAscIdAsc(personId);
    }
    
}
