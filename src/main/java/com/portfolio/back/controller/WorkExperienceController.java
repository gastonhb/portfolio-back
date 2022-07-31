package com.portfolio.back.controller;

import com.portfolio.back.dto.WorkExperienceDTO;
import com.portfolio.back.model.Person;
import com.portfolio.back.model.WorkExperience;
import com.portfolio.back.service.IPersonService;
import com.portfolio.back.service.IWorkExperienceService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkExperienceController {
    
    @Autowired
    private IWorkExperienceService service;
    @Autowired
    private IPersonService personService;
    
    @PostMapping ("/work-experiences")
    public ResponseEntity<WorkExperience> create (@RequestBody WorkExperienceDTO workExperienceDTO){
        Person person = personService.getById(workExperienceDTO.getPersonId());
        WorkExperience workExperience = new WorkExperience(
            workExperienceDTO.getTitle(),
            workExperienceDTO.getCompanyName(),
            workExperienceDTO.getStartDate(),
            workExperienceDTO.getEndDate(),
            workExperienceDTO.getWorkTime(),
            workExperienceDTO.getLocation(),
            person);
        WorkExperience newWorkExperience = service.create(workExperience);
        return new ResponseEntity<>(newWorkExperience,HttpStatus.CREATED);
    }
    
    @GetMapping ("/work-experiences")
    @ResponseBody
    public List<WorkExperience> list(){
       return service.list();
    }
    
    @GetMapping ("/work-experiences/{id}")
    @ResponseBody
    public ResponseEntity<WorkExperience> getById(@PathVariable UUID id){
        WorkExperience workExperience = service.getById(id);
        return new ResponseEntity<>(workExperience,HttpStatus.OK);
    }
    
    @DeleteMapping ("/work-experiences/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/work-experiences/{id}")
    public ResponseEntity<WorkExperience> update(@PathVariable UUID id, @RequestBody WorkExperienceDTO workExperienceDTO){
        Person person = personService.getById(workExperienceDTO.getPersonId());
        WorkExperience workExperience = new WorkExperience(
            id,
            workExperienceDTO.getTitle(),
            workExperienceDTO.getCompanyName(),
            workExperienceDTO.getStartDate(),
            workExperienceDTO.getEndDate(),
            workExperienceDTO.getWorkTime(),
            workExperienceDTO.getLocation(),
            person);
        WorkExperience updatedWorkExperience = service.update(workExperience);
        return new ResponseEntity<>(updatedWorkExperience, HttpStatus.OK);
    }
}
