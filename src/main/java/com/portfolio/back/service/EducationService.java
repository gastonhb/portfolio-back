package com.portfolio.back.service;

import com.portfolio.back.dto.EducationResponseDTO;
import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.Education;
import com.portfolio.back.repository.EducationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{
@Autowired
    public EducationRepository  repository;
    
    @Override
    public List<EducationResponseDTO> list() {
        List<Education> educations = repository.findAll();
        return this.convertToListResponseDTO(educations);
    }

    @Override
    public EducationResponseDTO create(Education education) {
        Education savedEducation = repository.save(education);
        return this.convertToResponseDTO(savedEducation);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public EducationResponseDTO getById(UUID id) {
        Education education =  repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Education", "id", id));
        return this.convertToResponseDTO(education);
    }
    
    @Override
    public EducationResponseDTO update(Education education) {
	Education savedEducation = repository.save(education);
        return this.convertToResponseDTO(savedEducation);
    }

    @Override
    public List<EducationResponseDTO> list(UUID personId) {
        List<Education> educations = repository.findAllByPersonIdOrderByStartDateAscIdAsc(personId);
        return this.convertToListResponseDTO(educations);
    }
    
    private EducationResponseDTO convertToResponseDTO(Education education){
        EducationResponseDTO educationResponseDTO = new
            EducationResponseDTO(
                education.getId(), 
                education.getTitle(),
                education.getInstitute(),
                education.getStartDate(),
                education.getEndDate(),
                education.getUrlImage(),
                education.getPerson().getId()
            );
        return educationResponseDTO;
    }
    
    private List<EducationResponseDTO> convertToListResponseDTO(List<Education> educations){
        List<EducationResponseDTO> educationsResponse = new ArrayList<>(); 
        for(Education education: educations){
            EducationResponseDTO educationResponseDTO = this.convertToResponseDTO(education);
            educationsResponse.add(educationResponseDTO);
        }
        return educationsResponse;
    }
    
}
