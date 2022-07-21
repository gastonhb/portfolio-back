package com.portfolio.back.repository;

import com.portfolio.back.model.Address;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository <Address, UUID>{
    
}
