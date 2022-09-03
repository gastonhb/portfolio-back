package com.portfolio.back.controller;

import com.portfolio.back.dto.UserDTO;
import com.portfolio.back.dto.UserResponse;
import com.portfolio.back.model.Person;
import com.portfolio.back.model.User;
import com.portfolio.back.service.IPersonService;
import com.portfolio.back.service.IUserService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private IUserService service;
    @Autowired
    private IPersonService personService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO){
        if(service.existsByUsername(userDTO.getUsername())) {
            return new ResponseEntity<>("This username already exist.",
                HttpStatus.BAD_REQUEST);
        }

        if(service.existsByEmail(userDTO.getEmail())) {
            return new ResponseEntity<>("This email already exist",
                HttpStatus.BAD_REQUEST);
        }
        
        UUID personId = userDTO.getPersonId();
        Person person;
        if(personId == null){
            person = new Person (userDTO.getName(), userDTO.getLastname());
            person = personService.create(person);
        } else {
            person = personService.getById(userDTO.getPersonId());
        }
        
        User user = new User();
        
        user.setPerson(person);
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        service.create(user);
        return new ResponseEntity<>("User successfully registered",
            HttpStatus.OK);
    }
    
    @GetMapping ("/users")
    @ResponseBody
    public List<User> list(){
       return service.list();
    }
    
    @GetMapping ("/users/{id}")
    @ResponseBody
    public UserResponse getById(@PathVariable UUID id){
        return service.getReferenceById(id);
    }
    
    @DeleteMapping ("/users/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
    
    @PutMapping ("/users/{id}")
    public void update(@PathVariable UUID id, @RequestBody UserDTO userDTO){
        Person person = personService.getById(userDTO.getPersonId());
        User user = new User(
            id,
            userDTO.getUsername(),
            userDTO.getPassword(),
            person);
        service.update(user);
    }
    
    @GetMapping ("/users/username/{username}")
    @ResponseBody
    public UserResponse getByUsername(@PathVariable String username){
        return service.getByUsername(username);
    }
}
