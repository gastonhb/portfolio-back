package com.portfolio.back.controller;

import com.portfolio.back.model.SkillType;
import com.portfolio.back.service.ISkillTypeService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillTypeController {
    
    @Autowired
    private ISkillTypeService service;
    
    @PostMapping ("/skill-types")
    public ResponseEntity<SkillType> create (@Valid @RequestBody SkillType skillType){
         SkillType newSkillType = service.create(skillType);
        return new ResponseEntity<>(newSkillType, HttpStatus.CREATED);
    }
    
    @GetMapping ("/skill-types")
    @ResponseBody
    public List<SkillType> list(){
       return service.list();
    }
    
    @GetMapping ("/skill-types/{id}")
    @ResponseBody
    public ResponseEntity<SkillType> getById(@PathVariable UUID id){
        SkillType skillType = service.getById(id);
        return new ResponseEntity<>(skillType,HttpStatus.OK);
    }
        
    
    @DeleteMapping ("/skill-types/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/skill-types/{id}")
    public ResponseEntity<SkillType> update(@PathVariable UUID id,
            @Valid @RequestBody SkillType skillType){
        skillType.setId(id);
        SkillType updatedSkillType = service.update(skillType);
        return new ResponseEntity<>(updatedSkillType, HttpStatus.OK);
    }
}
