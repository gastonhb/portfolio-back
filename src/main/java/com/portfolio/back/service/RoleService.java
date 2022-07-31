package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.Role;
import com.portfolio.back.repository.RoleRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService{
    
   @Autowired
    public RoleRepository  repository;
    
    @Override
    public List<Role> list() {
        return repository.findAll();
    }

    @Override
    public Role create(Role role) {
        return repository.save(role);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Role getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
    }
    
    @Override
    public Role update(Role role) {
	return repository.save(role);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return repository.findByName(name);
    }
    
}
