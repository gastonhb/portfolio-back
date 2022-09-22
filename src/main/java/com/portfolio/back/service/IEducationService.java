package com.portfolio.back.service;

import com.portfolio.back.dto.EducationResponseDTO;
import com.portfolio.back.model.Education;
import java.util.List;
import java.util.UUID;

public interface IEducationService {
    
    public List<EducationResponseDTO> list ();
    
    public EducationResponseDTO create (Education education);
    
    public void delete (UUID id);
    
    public EducationResponseDTO getById (UUID id);
    
    public EducationResponseDTO update (Education education);
    
    public List<EducationResponseDTO> list (UUID personId);
}
