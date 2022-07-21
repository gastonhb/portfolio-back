package com.portfolio.back.service;

import com.portfolio.back.model.WorkExperience;
import com.portfolio.back.repository.WorkExperienceRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceService extends BaseService<WorkExperience> implements IWorkExperienceService{
    
    public WorkExperienceService(WorkExperienceRepository repository) {
        super(repository);
    }

}
