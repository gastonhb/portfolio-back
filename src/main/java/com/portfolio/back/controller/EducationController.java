package com.portfolio.back.controller;

import com.portfolio.back.dto.EducationDTO;
import com.portfolio.back.model.Education;
import com.portfolio.back.model.Person;
import com.portfolio.back.service.IEducationService;
import com.portfolio.back.service.IPersonService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationController {
        
    @Autowired
    private IEducationService service;
    @Autowired
    private IPersonService personService;
    
    @PostMapping ("/educations")
    public ResponseEntity<Education> create (@RequestBody EducationDTO educationDTO){
        if(educationDTO.getPersonId() == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = personService.getById(educationDTO.getPersonId());
        Education education = new Education(
            educationDTO.getTitle(),
            educationDTO.getInstitute(),
            educationDTO.getStartDate(),
            educationDTO.getEndDate(),
            educationDTO.getUrlImage(),
            person);
        Education newEducation = service.create(education);
        return new ResponseEntity<>(newEducation,HttpStatus.CREATED);
    }
    
    @GetMapping ("/educations")
    @ResponseBody
    public List<Education> list(@RequestParam UUID personId){
        if(personId == null){
            return service.list();
        } else {
            return service.list(personId);
        }
    }
    
    @GetMapping ("/educations/{id}")
    @ResponseBody
    public ResponseEntity<Education> getById(@PathVariable UUID id){
        Education education = service.getById(id);
        return new ResponseEntity<>(education,HttpStatus.OK);
    }
    
    @DeleteMapping ("/educations/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/educations/{id}")
    public ResponseEntity<Education> update(@PathVariable UUID id, @RequestBody EducationDTO educationDTO){
        if(educationDTO.getPersonId() == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = personService.getById(educationDTO.getPersonId());
        Education education = new Education(
            id,
            educationDTO.getTitle(),
            educationDTO.getInstitute(),
            educationDTO.getStartDate(),
            educationDTO.getEndDate(),
            educationDTO.getUrlImage(),
            person);
        Education updatedEducation = service.update(education);
        return new ResponseEntity<>(updatedEducation, HttpStatus.OK);
    }
}
