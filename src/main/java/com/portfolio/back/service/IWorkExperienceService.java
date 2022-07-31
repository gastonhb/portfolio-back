
package com.portfolio.back.service;

import com.portfolio.back.model.WorkExperience;
import java.util.List;
import java.util.UUID;

public interface IWorkExperienceService {

    public List<WorkExperience> list ();
    
    public WorkExperience create (WorkExperience workExperience);
    
    public void delete (UUID id);
    
    public WorkExperience getById (UUID id);
    
    public WorkExperience update (WorkExperience workExperience);
}
