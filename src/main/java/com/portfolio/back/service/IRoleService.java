package com.portfolio.back.service;

import com.portfolio.back.model.Role;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRoleService {
    
    public List<Role> list ();
    
    public Role create (Role role);
    
    public void delete (UUID id);
    
    public Role getById (UUID id);
    
    public Role update (Role role);
    
    public Optional<Role> findByName(String name);
}
