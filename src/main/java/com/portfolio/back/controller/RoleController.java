package com.portfolio.back.controller;

import com.portfolio.back.model.Role;
import com.portfolio.back.service.IRoleService;
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
public class RoleController {
    
    @Autowired
    private IRoleService service;
    
    @PostMapping ("/roles")
    public ResponseEntity<Role> create (@RequestBody Role role){
        Role newRole = service.create(role);
        return new ResponseEntity<>(newRole,HttpStatus.CREATED);
    }
    
    @GetMapping ("/roles")
    @ResponseBody
    public List<Role> list(){
       return service.list();
    }
    
    @GetMapping ("/roles/{id}")
    @ResponseBody
    public ResponseEntity<Role> getById(@PathVariable UUID id){
        Role role = service.getById(id);
        return new ResponseEntity<>(role,HttpStatus.OK);
    }
    
    @DeleteMapping ("/roles/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/roles/{id}")
    public ResponseEntity<Role> update(@PathVariable UUID id, @RequestBody Role role){
        role.setId(id);
        Role updatedRole = service.update(role);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }
}
