package com.portfolio.back.controller;

import com.portfolio.back.dto.SkillDTO;
import com.portfolio.back.model.Skill;
import com.portfolio.back.model.Person;
import com.portfolio.back.service.ISkillService;
import com.portfolio.back.service.IPersonService;
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
public class SkillController {
    
    @Autowired
    private ISkillService service;
    @Autowired
    private IPersonService personService;
    
    @PostMapping ("/skills")
    public void create (@RequestBody SkillDTO skillDTO){
        Person person = personService.getById(skillDTO.getPersonId());
        Skill skill = new Skill(
            skillDTO.getName(),
            skillDTO.getType(),
            skillDTO.getGrade(),
            person);
        service.create(skill);
    }
    
    @GetMapping ("/skills")
    @ResponseBody
    public List<Skill> list(){
       return service.list();
    }
    
    @GetMapping ("/skills/{id}")
    @ResponseBody
    public Skill getById(@PathVariable UUID id){
        return service.getById(id);
    }
    
    @DeleteMapping ("/skills/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
    
    @PutMapping ("/skills/{id}")
    public void update(@PathVariable UUID id, @RequestBody SkillDTO skillDTO){
        Person person = personService.getById(skillDTO.getPersonId());
        Skill skill = new Skill(
            id,
            skillDTO.getName(),
            skillDTO.getType(),
            skillDTO.getGrade(),
            person);
        service.update(skill);
    }
}
