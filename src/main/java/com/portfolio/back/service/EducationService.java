package com.portfolio.back.service;

import com.portfolio.back.model.Education;
import com.portfolio.back.repository.EducationRepository;
import org.springframework.stereotype.Service;

@Service
public class EducationService extends BaseService<Education> implements IEducationService{

    public EducationService(EducationRepository repository) {
        super(repository);
    }
    
}
