package com.portfolio.back.repository;

import com.portfolio.back.model.Person;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, UUID>{
    
    public List<Person> findAllByOrderByLastnameAscNameAscIdAsc();
}