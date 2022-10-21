package com.portfolio.back.controller;

import com.portfolio.back.dto.WorkExperienceRequestDTO;
import com.portfolio.back.dto.WorkExperienceResponseDTO;
import com.portfolio.back.model.Person;
import com.portfolio.back.model.WorkExperience;
import com.portfolio.back.model.WorkTimeType;
import com.portfolio.back.service.IPersonService;
import com.portfolio.back.service.IWorkExperienceService;
import com.portfolio.back.service.IWorkTimeTypeService;
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
public class WorkExperienceController {
    
    @Autowired
    private IWorkExperienceService service;
    
    @Autowired
    private IPersonService personService;
    
    @Autowired
    private IWorkTimeTypeService workTimeTypeService;
    
    @PostMapping ("/work-experiences")
    public ResponseEntity<WorkExperienceResponseDTO> create (@RequestBody WorkExperienceRequestDTO workExperienceRequestDTO){
        if(workExperienceRequestDTO.getPersonId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        if(workExperienceRequestDTO.getWorkTimeTypeId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Person person = personService.getById(workExperienceRequestDTO.getPersonId());
        WorkTimeType workTimeType = workTimeTypeService.getById(workExperienceRequestDTO.getWorkTimeTypeId());
        WorkExperience workExperience = new WorkExperience(
            workExperienceRequestDTO.getTitle(),
            workExperienceRequestDTO.getCompanyName(),
            workExperienceRequestDTO.getStartDate(),
            workExperienceRequestDTO.getEndDate(),
            workExperienceRequestDTO.getLocation(),
            workExperienceRequestDTO.getUrlImage(),
            person,
            workTimeType);
        WorkExperienceResponseDTO workExperienceResponseDTO = service.create(workExperience);
        return new ResponseEntity<>(workExperienceResponseDTO, HttpStatus.CREATED);
    }
    
    @GetMapping ("/work-experiences")
    @ResponseBody
    public List<WorkExperienceResponseDTO> list(@RequestParam(required = false) UUID personId){
       if(personId == null){
            return service.list();
        } else {
            return service.list(personId); 
        }
    }
    
    @GetMapping ("/work-experiences/{id}")
    @ResponseBody
    public ResponseEntity<WorkExperienceResponseDTO> getById(@PathVariable UUID id){
        WorkExperienceResponseDTO workExperienceResponseDTO = service.getById(id);
        return new ResponseEntity<>(workExperienceResponseDTO, HttpStatus.OK);
    }
    
    @DeleteMapping ("/work-experiences/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/work-experiences/{id}")
    public ResponseEntity<WorkExperienceResponseDTO> update(@PathVariable UUID id, @RequestBody WorkExperienceRequestDTO workExperienceRequestDTO){
        Person person = personService.getById(workExperienceRequestDTO.getPersonId());
        WorkTimeType workTimeType = workTimeTypeService.getById(
            workExperienceRequestDTO.getWorkTimeTypeId());
        
        WorkExperience workExperience = new WorkExperience(
            id,
            workExperienceRequestDTO.getTitle(),
            workExperienceRequestDTO.getCompanyName(),
            workExperienceRequestDTO.getStartDate(),
            workExperienceRequestDTO.getEndDate(),
            workExperienceRequestDTO.getLocation(),
            workExperienceRequestDTO.getUrlImage(),
            person,
            workTimeType);
        WorkExperienceResponseDTO workExperienceResponseDTO = service.update(workExperience);
        return new ResponseEntity<>(workExperienceResponseDTO, HttpStatus.OK);
    }
}
