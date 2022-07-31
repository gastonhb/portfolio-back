package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.Project;
import com.portfolio.back.repository.ProjectRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    public ProjectRepository  repository;
    
    @Override
    public List<Project> list() {
        return repository.findAll();
    }

    @Override
    public Project create(Project project) {
        return repository.save(project);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Project getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
    }
    
    @Override
    public Project update(Project project) {
	return repository.save(project);
    }

}
