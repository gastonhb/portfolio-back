package com.portfolio.back.service;

import com.portfolio.back.dto.WorkExperienceResponseDTO;
import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.WorkExperience;
import com.portfolio.back.repository.WorkExperienceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceService implements IWorkExperienceService{
    
    @Autowired
    public WorkExperienceRepository  repository;
    
    @Override
    public List<WorkExperienceResponseDTO> list() {
        List<WorkExperience> workExperiences = repository.findAll();
        return this.convertToListResponseDTO(workExperiences);
    }

    @Override
    public WorkExperienceResponseDTO create(WorkExperience workExperience) {
        WorkExperience savedWorkExperience = repository.save(workExperience);
        return this.convertToResponseDTO(savedWorkExperience);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public WorkExperienceResponseDTO getById(UUID id) {
        WorkExperience workExperience = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("WorkExperience", "id", id));
        return this.convertToResponseDTO(workExperience);
    }
    
    @Override
    public WorkExperienceResponseDTO update(WorkExperience workExperience) {
	WorkExperience savedWorkExperience = repository.save(workExperience);
        return this.convertToResponseDTO(savedWorkExperience);
    }
    
    @Override
    public List<WorkExperienceResponseDTO> list(UUID personId) {
        List<WorkExperience> workExperiences = repository.findAllByPersonIdOrderByTitleAscIdAsc(personId);
        return this.convertToListResponseDTO(workExperiences);
    }
    
    private WorkExperienceResponseDTO convertToResponseDTO(WorkExperience workExperience){
        WorkExperienceResponseDTO workExperienceResponseDTO = new
            WorkExperienceResponseDTO(
                workExperience.getId(), 
                workExperience.getTitle(),
                workExperience.getCompanyName(),
                workExperience.getStartDate(),
                workExperience.getEndDate(),
                workExperience.getLocation(),
                workExperience.getUrlImage(),
                workExperience.getPerson().getId(),
                workExperience.getWorkTimeType().getId(),
                workExperience.getWorkTimeType()
            );
        return workExperienceResponseDTO;
    }
    
    private List<WorkExperienceResponseDTO> convertToListResponseDTO(List<WorkExperience> workExperiences){
        
        List<WorkExperienceResponseDTO> workExperiencesResponse = new ArrayList<>(); 
        for(WorkExperience workExperience: workExperiences){
            WorkExperienceResponseDTO workExperienceResponseDTO = this.convertToResponseDTO(workExperience);
            workExperiencesResponse.add(workExperienceResponseDTO);
        }
        return workExperiencesResponse;
    }

}
