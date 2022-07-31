package com.portfolio.back.service;

import com.portfolio.back.model.Education;
import java.util.List;
import java.util.UUID;

public interface IEducationService {
    
    public List<Education> list ();
    
    public Education create (Education education);
    
    public void delete (UUID id);
    
    public Education getById (UUID id);
    
    public Education update (Education education);
}
