package com.portfolio.back.service;

import com.portfolio.back.model.Project;
import com.portfolio.back.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends BaseService<Project> implements IProjectService {

    public ProjectService(ProjectRepository repository) {
        super(repository);
    }

}
