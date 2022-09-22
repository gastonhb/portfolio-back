package com.portfolio.back.service;

import com.portfolio.back.dto.ProjectResponseDTO;
import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.Project;
import com.portfolio.back.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    public ProjectRepository  repository;
    
    @Override
    public List<ProjectResponseDTO> list() {
        List<Project> projects = repository.findAll();
        return this.convertToListResponseDTO(projects);
    }

    @Override
    public ProjectResponseDTO create(Project project) {
        Project savedProject = repository.save(project);
        return this.convertToResponseDTO(savedProject);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public ProjectResponseDTO getById(UUID id) {
        Project project =  repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
        return this.convertToResponseDTO(project);
    }
    
    @Override
    public ProjectResponseDTO update(Project project) {
	Project savedProject = repository.save(project);
        return this.convertToResponseDTO(savedProject);
    }
    
    @Override
    public List<ProjectResponseDTO> list(UUID personId) {
        List<Project> projects = repository.findAllByPersonIdOrderByNameAscIdAsc(personId);
        return this.convertToListResponseDTO(projects);
    }
    
    private ProjectResponseDTO convertToResponseDTO(Project project){
        ProjectResponseDTO projectResponseDTO = new
            ProjectResponseDTO(
                project.getId(), 
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate(),
                project.getLink(),
                project.getUrlImage(),
                project.getPerson().getId()
            );
        return projectResponseDTO;
    }
    
    private List<ProjectResponseDTO> convertToListResponseDTO(List<Project> projects){
        List<ProjectResponseDTO> projectsResponse = new ArrayList<>(); 
        for(Project project: projects){
            ProjectResponseDTO projectResponseDTO = this.convertToResponseDTO(project);
            projectsResponse.add(projectResponseDTO);
        }
        return projectsResponse;
    }

}
