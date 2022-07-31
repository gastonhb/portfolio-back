package com.portfolio.back.repository;

import com.portfolio.back.model.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, UUID> {
    public Optional<User> findByEmail(String email);
	
    public Optional<User> findByUsernameOrEmail(String username,String email);

    public Optional<User> findByUsername(String username);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);
}
