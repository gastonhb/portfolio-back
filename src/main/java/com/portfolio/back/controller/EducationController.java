package com.portfolio.back.controller;

import com.portfolio.back.dto.EducationRequestDTO;
import com.portfolio.back.dto.EducationResponseDTO;
import com.portfolio.back.model.Education;
import com.portfolio.back.model.Person;
import com.portfolio.back.service.IEducationService;
import com.portfolio.back.service.IPersonService;
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
public class EducationController {
        
    @Autowired
    private IEducationService service;
    
    @Autowired
    private IPersonService personService;
    
    @PostMapping ("/educations")
    public ResponseEntity<EducationResponseDTO> create (@Valid @RequestBody EducationRequestDTO educationRequestDTO){
        Person person = personService.getById(educationRequestDTO.getPersonId());
        Education education = new Education(
            educationRequestDTO.getTitle(),
            educationRequestDTO.getInstitute(),
            educationRequestDTO.getStartDate(),
            educationRequestDTO.getEndDate(),
            educationRequestDTO.getUrlImage(),
            person);
        EducationResponseDTO educationResponseDTO = service.create(education);
        return new ResponseEntity<>(educationResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping ("/educations")
    @ResponseBody
    public List<EducationResponseDTO> list(@RequestParam(required = false) UUID personId){
        if(personId == null){
            return service.list();
        } else {
            return service.list(personId);
        }
    }
    
    @GetMapping ("/educations/{id}")
    @ResponseBody
    public ResponseEntity<EducationResponseDTO> getById(@PathVariable UUID id){
        EducationResponseDTO educationResponseDTO = service.getById(id);
        return new ResponseEntity<>(educationResponseDTO, HttpStatus.OK);
    }
    
    @DeleteMapping ("/educations/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/educations/{id}")
    public ResponseEntity<EducationResponseDTO> update(@PathVariable UUID id, @RequestBody EducationRequestDTO educationRequestDTO){
        Person person = personService.getById(educationRequestDTO.getPersonId());
        Education education = new Education(
            id,
            educationRequestDTO.getTitle(),
            educationRequestDTO.getInstitute(),
            educationRequestDTO.getStartDate(),
            educationRequestDTO.getEndDate(),
            educationRequestDTO.getUrlImage(),
            person);
        EducationResponseDTO educationResponseDTO = service.update(education);
        return new ResponseEntity<>(educationResponseDTO, HttpStatus.OK);
    }
}
