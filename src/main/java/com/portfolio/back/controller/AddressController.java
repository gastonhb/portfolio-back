package com.portfolio.back.controller;

import com.portfolio.back.model.Address;
import com.portfolio.back.service.IAddressService;
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
public class AddressController {
        
    @Autowired
    private IAddressService service;
    
    @PostMapping ("/addresses")
    public void create (@RequestBody Address address){
        service.create(address);
    }
    
    @GetMapping ("/addresses")
    @ResponseBody
    public List<Address> list(){
       return service.list();
    }
    
    @GetMapping ("/addresses/{id}")
    @ResponseBody
    public Address getById(@PathVariable UUID id){
        return service.getById(id);
    }
    
    @DeleteMapping ("/addresses/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
    
    @PutMapping ("/addresses/{id}")
    public void update(@PathVariable UUID id, @RequestBody Address address){
        address.setId(id);
        service.update(address);
    }
}
