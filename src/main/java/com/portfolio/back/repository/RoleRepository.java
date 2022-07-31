package com.portfolio.back.repository;

import com.portfolio.back.model.Role;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, UUID>{

    public Optional<Role> findByName(String name);
    
}
