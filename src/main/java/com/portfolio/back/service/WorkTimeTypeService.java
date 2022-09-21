package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.WorkTimeType;
import com.portfolio.back.repository.WorkTimeTypeRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkTimeTypeService implements IWorkTimeTypeService {
    
    @Autowired
    public WorkTimeTypeRepository  repository;
    
    @Override
    public List<WorkTimeType> list() {
        return repository.findAllByOrderByNameAscIdAsc();
    }

    @Override
    public WorkTimeType create(WorkTimeType workTimeType) {
        return repository.save(workTimeType);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public WorkTimeType getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("WorkTimeType", "id", id));
    }
    
    @Override
    public WorkTimeType update(WorkTimeType workTimeType) {
	return repository.save(workTimeType);
    }
    
}
