package com.portfolio.back.controller;

import com.portfolio.back.dto.ProjectRequestDTO;
import com.portfolio.back.dto.ProjectResponseDTO;
import com.portfolio.back.model.Person;
import com.portfolio.back.model.Project;
import com.portfolio.back.service.IPersonService;
import com.portfolio.back.service.IProjectService;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
        
    @Autowired
    private IProjectService service;
    
    @Autowired
    private IPersonService personService;
    
    @PostMapping ("/projects")
    public ResponseEntity<ProjectResponseDTO> create (@Valid @RequestBody ProjectRequestDTO projectDTO){
        Person person = personService.getById(projectDTO.getPersonId());
        Project project = new Project(
            projectDTO.getName(),
            projectDTO.getDescription(),
            projectDTO.getStartDate(),
            projectDTO.getEndDate(),
            projectDTO.getLink(),
            projectDTO.getUrlImage(),
            person);
        ProjectResponseDTO projectResponseDTO = service.create(project);
        return new ResponseEntity<>(projectResponseDTO, HttpStatus.CREATED);
    }
    
    @GetMapping ("/projects")
    @ResponseBody
    public List<ProjectResponseDTO> list(@RequestParam(required = false) UUID personId){
        if(personId == null){
            return service.list();
        } else {
            return service.list(personId); 
        }
    }
    
    @GetMapping ("/projects/{id}")
    @ResponseBody
    public ResponseEntity<ProjectResponseDTO> getById(@PathVariable UUID id){
        ProjectResponseDTO projectResponseDTO = service.getById(id);
        return new ResponseEntity<>(projectResponseDTO, HttpStatus.OK);
    }
    
    @DeleteMapping ("/projects/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/projects/{id}")
    public ResponseEntity<ProjectResponseDTO> update(@Valid @PathVariable UUID id, 
        @RequestBody ProjectRequestDTO projectDTO){
        Person person = personService.getById(projectDTO.getPersonId());
        Project project = new Project(
            id,
            projectDTO.getName(),
            projectDTO.getDescription(),
            projectDTO.getStartDate(),
            projectDTO.getEndDate(),
            projectDTO.getLink(),
            projectDTO.getUrlImage(),
            person);
        ProjectResponseDTO projectResponseDTO = service.update(project);
        return new ResponseEntity<>(projectResponseDTO, HttpStatus.OK);
    }
}
