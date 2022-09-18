package com.portfolio.back.controller;

import com.portfolio.back.dto.SkillRequestDTO;
import com.portfolio.back.dto.SkillResponseDTO;
import com.portfolio.back.model.Skill;
import com.portfolio.back.model.Person;
import com.portfolio.back.model.SkillType;
import com.portfolio.back.service.ISkillService;
import com.portfolio.back.service.IPersonService;
import com.portfolio.back.service.ISkillTypeService;
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
public class SkillController {
    
    @Autowired
    private ISkillService service;
    
    @Autowired
    private IPersonService personService;
    
    @Autowired
    private ISkillTypeService skillTypeService;
    
    @PostMapping ("/skills")
    public ResponseEntity<SkillResponseDTO> create (@RequestBody SkillRequestDTO skillRequestDTO){
        if(skillRequestDTO.getPersonId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        if(skillRequestDTO.getSkillTypeId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Person person = personService.getById(skillRequestDTO.getPersonId());
        SkillType skillType = skillTypeService.getById(
            skillRequestDTO.getSkillTypeId());
        Skill skill = new Skill(
            skillRequestDTO.getName(),
            skillRequestDTO.getGrade(),
            person,
            skillType);
        SkillResponseDTO skillResponseDTO = service.create(skill);
        return new ResponseEntity<>(skillResponseDTO, HttpStatus.CREATED);
    }
    
    @GetMapping ("/skills")
    @ResponseBody
    public List<SkillResponseDTO> list(@RequestParam(required = false) UUID personId){
        if(personId == null){
            return service.list();
        } else {
            return service.list(personId); 
        }
    }
    
    @GetMapping ("/skills/{id}")
    @ResponseBody
    public ResponseEntity<SkillResponseDTO> getById(@PathVariable UUID id){
        SkillResponseDTO skillResponseDTO = service.getById(id);
        return new ResponseEntity<>(skillResponseDTO, HttpStatus.OK);
    }
    
    @DeleteMapping ("/skills/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/skills/{id}")
    public ResponseEntity<SkillResponseDTO> update(@PathVariable UUID id, @RequestBody SkillRequestDTO skillRequestDTO){
        if(skillRequestDTO.getPersonId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        if(skillRequestDTO.getSkillTypeId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Person person = personService.getById(skillRequestDTO.getPersonId());
        SkillType skillType = skillTypeService.getById(
            skillRequestDTO.getSkillTypeId());
        Skill skill = new Skill(
            id,
            skillRequestDTO.getName(),
            skillRequestDTO.getGrade(),
            person,
            skillType);
        SkillResponseDTO skillResponseDTO = service.update(skill);
        return new ResponseEntity<>(skillResponseDTO, HttpStatus.OK);
    }
}
