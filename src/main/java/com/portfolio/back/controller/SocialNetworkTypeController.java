package com.portfolio.back.controller;

import com.portfolio.back.model.SocialNetworkType;
import com.portfolio.back.service.ISocialNetworkTypeService;
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
public class SocialNetworkTypeController {
    
    @Autowired
    private ISocialNetworkTypeService service;
    
    @PostMapping ("/social-network-types")
    public ResponseEntity<SocialNetworkType> create (@RequestBody SocialNetworkType socialNetworkType){
         SocialNetworkType newSocialNetworkType = service.create(socialNetworkType);
        return new ResponseEntity<>(newSocialNetworkType, HttpStatus.CREATED);
    }
    
    @GetMapping ("/social-network-types")
    @ResponseBody
    public List<SocialNetworkType> list(){
       return service.list();
    }
    
    @GetMapping ("/social-network-types/{id}")
    @ResponseBody
    public ResponseEntity<SocialNetworkType> getById(@PathVariable UUID id){
        SocialNetworkType socialNetworkType = service.getById(id);
        return new ResponseEntity<>(socialNetworkType,HttpStatus.OK);
    }
        
    
    @DeleteMapping ("/social-network-types/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/social-network-types/{id}")
    public ResponseEntity<SocialNetworkType> update(@PathVariable UUID id,
            @RequestBody SocialNetworkType socialNetworkType){
        socialNetworkType.setId(id);
        SocialNetworkType updatedSocialNetworkType = service.update(socialNetworkType);
        return new ResponseEntity<>(updatedSocialNetworkType, HttpStatus.OK);
    }
}
