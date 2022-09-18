package com.portfolio.back.service;

import com.portfolio.back.dto.ProjectResponseDTO;
import com.portfolio.back.model.Project;
import java.util.List;
import java.util.UUID;

public interface IProjectService {
    
    public List<ProjectResponseDTO> list ();
    
    public ProjectResponseDTO create (Project project);
    
    public void delete (UUID id);
    
    public ProjectResponseDTO getById (UUID id);
    
    public ProjectResponseDTO update (Project project);
    
    public List<ProjectResponseDTO> list (UUID personId);
}
