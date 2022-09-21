package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.Person;
import com.portfolio.back.repository.PersonRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
   
    @Autowired
    public PersonRepository  repository;
    
    @Override
    public List<Person> list() {
        return repository.findAllByOrderByLastnameAscNameAscIdAsc();
    }

    @Override
    public Person create(Person person) {
        return repository.save(person);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Person getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
    }
    
    @Override
    public Person update(Person person) {
	return repository.save(person);
    }

}
