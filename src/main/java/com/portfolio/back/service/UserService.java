package com.portfolio.back.service;

import com.portfolio.back.model.User;
import com.portfolio.back.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> implements IUserService{

    public UserService(UserRepository repository) {
        super(repository);
    }
    
}
