package com.portfolio.back.service;

import com.portfolio.back.model.Project;
import java.util.List;
import java.util.UUID;

public interface IProjectService {
    
    public List<Project> list ();
    
    public Project create (Project project);
    
    public void delete (UUID id);
    
    public Project getById (UUID id);
    
    public Project update (Project project);
}
