package com.portfolio.back.service;

import com.portfolio.back.dto.UserResponseDTO;
import com.portfolio.back.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {
    
    public List<User> list ();
    
    public User create (User user);
    
    public void delete (UUID id);
    
    public UserResponseDTO getReferenceById (UUID id);
    
    public UserResponseDTO getByUsername (String username);
    
    public User update (User user);
    
    public Optional<User> findByUsername(String username);
    
    public Optional<User> findByEmail(String email);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);
}
