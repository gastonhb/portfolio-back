package com.portfolio.back.service;

import com.portfolio.back.model.Person;
import com.portfolio.back.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person> implements IPersonService {
   
    public PersonService(PersonRepository repository) {
        super(repository);
    }

}
