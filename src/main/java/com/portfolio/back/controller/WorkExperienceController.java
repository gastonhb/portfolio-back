package com.portfolio.back.controller;

import com.portfolio.back.dto.WorkExperienceDTO;
import com.portfolio.back.model.Person;
import com.portfolio.back.model.WorkExperience;
import com.portfolio.back.service.IPersonService;
import com.portfolio.back.service.IWorkExperienceService;
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
public class WorkExperienceController {
    
    @Autowired
    private IWorkExperienceService service;
    @Autowired
    private IPersonService personService;
    
    @PostMapping ("/work-experiences")
    public void create (@RequestBody WorkExperienceDTO workExperienceDTO){
        Person person = personService.getById(workExperienceDTO.getPersonId());
        WorkExperience workExperience = new WorkExperience(
            workExperienceDTO.getTitle(),
            workExperienceDTO.getCompanyName(),
            workExperienceDTO.getStartDate(),
            workExperienceDTO.getEndDate(),
            workExperienceDTO.getWorkTime(),
            workExperienceDTO.getLocation(),
            person);
        service.create(workExperience);
    }
    
    @GetMapping ("/work-experiences")
    @ResponseBody
    public List<WorkExperience> list(){
       return service.list();
    }
    
    @GetMapping ("/work-experiences/{id}")
    @ResponseBody
    public WorkExperience getById(@PathVariable UUID id){
        return service.getById(id);
    }
    
    @DeleteMapping ("/work-experiences/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
    
    @PutMapping ("/work-experiences/{id}")
    public void update(@PathVariable UUID id, @RequestBody WorkExperienceDTO workExperienceDTO){
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
        service.update(workExperience);
    }
}
