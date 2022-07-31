package com.portfolio.back.service;

import com.portfolio.back.model.Person;
import java.util.List;
import java.util.UUID;

public interface IPersonService {

    public List<Person> list ();
    
    public Person create (Person person);
    
    public void delete (UUID id);
    
    public Person getById (UUID id);
    
    public Person update (Person person);
}
