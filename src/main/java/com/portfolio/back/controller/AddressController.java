package com.portfolio.back.controller;

import com.portfolio.back.model.Address;
import com.portfolio.back.service.IAddressService;
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
public class AddressController {
        
    @Autowired
    private IAddressService service;
    
    @PostMapping ("/addresses")
    public ResponseEntity<Address> create (@RequestBody Address address){
        Address newAddress = service.create(address);
        return new ResponseEntity<>(newAddress,HttpStatus.CREATED);
    }
    
    @GetMapping ("/addresses")
    @ResponseBody
    public List<Address> list(){
       return service.list();
    }
    
    @GetMapping ("/addresses/{id}")
    @ResponseBody
    public ResponseEntity<Address> getById(@PathVariable UUID id){
        Address address = service.getById(id);
        return new ResponseEntity<>(address,HttpStatus.OK);
    }
    
    @DeleteMapping ("/addresses/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/addresses/{id}")
    public ResponseEntity<Address> update(@PathVariable UUID id, @RequestBody Address address){
        address.setId(id);
        Address updatedAddress = service.update(address);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }
}
