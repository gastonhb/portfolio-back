
package com.portfolio.back.service;

import com.portfolio.back.dto.WorkExperienceResponseDTO;
import com.portfolio.back.model.WorkExperience;
import java.util.List;
import java.util.UUID;

public interface IWorkExperienceService {

    public List<WorkExperienceResponseDTO> list ();
    
    public WorkExperienceResponseDTO create (WorkExperience workExperience);
    
    public void delete (UUID id);
    
    public WorkExperienceResponseDTO getById (UUID id);
    
    public WorkExperienceResponseDTO update (WorkExperience workExperience);
    
    public List<WorkExperienceResponseDTO> list(UUID personId);

}
