package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.User;
import com.portfolio.back.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.back.dto.UserResponse;

@Service
public class UserService implements IUserService{

    @Autowired
    public UserRepository  repository;
    
    @Override
    public List<User> list() {
        return repository.findAll();
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public UserResponse getReferenceById(UUID id) {
        User user = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return new UserResponse(user.getId(), user.getUsername(),
                user.getEmail(), user.getPerson());
    }
    
    @Override
    public User update(User user) {
	return repository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);    
    }

    @Override
    public Boolean existsByEmail(String email) {
         return repository.existsByEmail(email);
    }
    
    @Override
    public UserResponse getByUsername(String username) {
        User user = repository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        return new UserResponse(user.getId(), user.getUsername(),
                user.getEmail(), user.getPerson());
    }
}
