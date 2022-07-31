package com.portfolio.back.service;

import com.portfolio.back.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {
    
    public List<User> list ();
    
    public User create (User user);
    
    public void delete (UUID id);
    
    public User getById (UUID id);
    
    public User update (User user);
    
    public Optional<User> findByUsername(String username);
    
    public Optional<User> findByEmail(String email);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);
}
