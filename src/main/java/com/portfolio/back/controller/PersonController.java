package com.portfolio.back.controller;

import com.portfolio.back.dto.PersonDTO;
import com.portfolio.back.model.Address;
import com.portfolio.back.model.Person;
import com.portfolio.back.service.IAddressService;
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
public class PersonController {
    
    @Autowired
    private IPersonService service;
    @Autowired
    private IAddressService addressService;
    
    @PostMapping ("/persons")
    public void create (@RequestBody PersonDTO personDTO){
        Address address = addressService.getById(personDTO.getAddressId());
        Person person = new Person(
            personDTO.getName(),
            personDTO.getLastname(),
            personDTO.getTitle(),
            personDTO.getAbstracts(),
            address
        );
        service.create(person);
    }
    
    @GetMapping ("/persons")
    @ResponseBody
    public List<Person> list(){
       return service.list();
    }
    
    @GetMapping ("/persons/{id}")
    @ResponseBody
    public Person getById(@PathVariable UUID id){
        return service.getById(id);
    }
    
    @DeleteMapping ("/persons/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
    
    @PutMapping ("/persons/{id}")
    public void update(@PathVariable UUID id, @RequestBody PersonDTO personDTO){
        Address address = addressService.getById(personDTO.getAddressId());
        Person person = new Person(
            id,
            personDTO.getName(),
            personDTO.getLastname(),
            personDTO.getTitle(),
            personDTO.getAbstracts(),
            address
        );
        service.update(person);
    }
}
