package com.portfolio.back.controller;

import com.portfolio.back.dto.ProjectDTO;
import com.portfolio.back.model.Person;
import com.portfolio.back.model.Project;
import com.portfolio.back.service.IPersonService;
import com.portfolio.back.service.IProjectService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
        
    @Autowired
    private IProjectService service;
    @Autowired
    private IPersonService personService;
    
    @PostMapping ("/projects")
    public void create (@RequestBody ProjectDTO projectDTO){
        Person person = personService.getById(projectDTO.getPersonId());
        Project project = new Project(
            projectDTO.getName(),
            projectDTO.getDescription(),
            projectDTO.getRealizationDate(),
            projectDTO.getLink(),
            person);
        service.create(project);
    }
    
    @GetMapping ("/projects")
    @ResponseBody
    public List<Project> list(){
       return service.list();
    }
    
    @GetMapping ("/projects/{id}")
    @ResponseBody
    public Project getById(@PathVariable UUID id){
        return service.getById(id);
    }
    
    @DeleteMapping ("/projects/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
    
    @PutMapping ("/projects/{id}")
    public void update(@PathVariable UUID id, @RequestBody ProjectDTO projectDTO){
        Person person = personService.getById(projectDTO.getPersonId());
        Project project = new Project(
            id,
            projectDTO.getName(),
            projectDTO.getDescription(),
            projectDTO.getRealizationDate(),
            projectDTO.getLink(),
            person);
        service.update(project);
    }
}
