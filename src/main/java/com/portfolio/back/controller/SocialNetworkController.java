package com.portfolio.back.controller;

import com.portfolio.back.dto.SocialNetworkRequestDTO;
import com.portfolio.back.dto.SocialNetworkResponseDTO;
import com.portfolio.back.model.Person;
import com.portfolio.back.model.SocialNetwork;
import com.portfolio.back.model.SocialNetworkType;
import com.portfolio.back.service.IPersonService;
import com.portfolio.back.service.ISocialNetworkService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialNetworkController {
    
    @Autowired
    private ISocialNetworkService service;
    @Autowired
    private IPersonService personService;
    @Autowired
    private ISocialNetworkTypeService socialNetworkTypeService;
    
    @PostMapping ("/social-networks")
    public ResponseEntity<SocialNetworkResponseDTO> create (@RequestBody SocialNetworkRequestDTO socialNetworkRequestDTO){
        if(socialNetworkRequestDTO.getPersonId() == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        if(socialNetworkRequestDTO.getSocialNetworkTypeId() == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Person person = personService.getById(socialNetworkRequestDTO.getPersonId());
        SocialNetworkType socialNetworkType = socialNetworkTypeService.getById(
                socialNetworkRequestDTO.getSocialNetworkTypeId());
        SocialNetwork socialNetwork = new SocialNetwork(
            socialNetworkRequestDTO.getContent(),
            person,
            socialNetworkType);
        SocialNetworkResponseDTO socialNetworkResponseDTO = service.create(socialNetwork);
        return new ResponseEntity<>(socialNetworkResponseDTO, HttpStatus.CREATED);
    }
    
    @GetMapping ("/social-networks")
    @ResponseBody
    public List<SocialNetworkResponseDTO> list(@RequestParam(required = false) UUID personId){
       if(personId == null){
            return service.list();
        } else {
            return service.list(personId); 
        }
    }
    
    @GetMapping ("/social-networks/{id}")
    @ResponseBody
    public ResponseEntity<SocialNetworkResponseDTO> getById(@PathVariable UUID id){
        SocialNetworkResponseDTO socialNetworkResponseDTO = service.getById(id);
        return new ResponseEntity<>(socialNetworkResponseDTO, HttpStatus.OK);
    }
    
    @DeleteMapping ("/social-networks/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/social-networks/{id}")
    public ResponseEntity<SocialNetworkResponseDTO> update(@PathVariable UUID id, 
            @RequestBody SocialNetworkRequestDTO socialNetworkRequestDTO){
        if(socialNetworkRequestDTO.getPersonId() == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        if(socialNetworkRequestDTO.getSocialNetworkTypeId() == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = personService.getById(socialNetworkRequestDTO.getPersonId());
        SocialNetworkType socialNetworkType = socialNetworkTypeService.getById(
            socialNetworkRequestDTO.getSocialNetworkTypeId());
        SocialNetwork socialNetwork = new SocialNetwork(
            id,
            socialNetworkRequestDTO.getContent(),
            person,
            socialNetworkType);
        SocialNetworkResponseDTO socialNetworkResponseDTO = service.update(socialNetwork);
        return new ResponseEntity<>(socialNetworkResponseDTO, HttpStatus.OK);
    }
}
