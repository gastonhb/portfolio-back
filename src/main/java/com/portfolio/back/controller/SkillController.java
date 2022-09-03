package com.portfolio.back.controller;

import com.portfolio.back.dto.SkillDTO;
import com.portfolio.back.model.Skill;
import com.portfolio.back.model.Person;
import com.portfolio.back.service.ISkillService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {
    
    @Autowired
    private ISkillService service;
    @Autowired
    private IPersonService personService;
    
    @PostMapping ("/skills")
    public ResponseEntity<Skill> create (@RequestBody SkillDTO skillDTO){
        if(skillDTO.getPersonId() == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = personService.getById(skillDTO.getPersonId());
        Skill skill = new Skill(
            skillDTO.getName(),
            skillDTO.getType(),
            skillDTO.getGrade(),
            person);
        Skill newSkill = service.create(skill);
        return new ResponseEntity<>(newSkill,HttpStatus.CREATED);
    }
    
    @GetMapping ("/skills")
    @ResponseBody
    public List<Skill> list(){
       return service.list();
    }
    
    @GetMapping ("/skills/{id}")
    @ResponseBody
    public ResponseEntity<Skill> getById(@PathVariable UUID id){
        Skill skill = service.getById(id);
        return new ResponseEntity<>(skill,HttpStatus.OK);
    }
    
    @DeleteMapping ("/skills/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/skills/{id}")
    public ResponseEntity<Skill> update(@PathVariable UUID id, @RequestBody SkillDTO skillDTO){
        if(skillDTO.getPersonId() == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = personService.getById(skillDTO.getPersonId());
        Skill skill = new Skill(
            id,
            skillDTO.getName(),
            skillDTO.getType(),
            skillDTO.getGrade(),
            person);
        Skill updatedSkill = service.update(skill);
        return new ResponseEntity<>(updatedSkill, HttpStatus.OK);
    }
}
