package com.portfolio.back.service;

import com.portfolio.back.model.WorkTimeType;
import java.util.List;
import java.util.UUID;


public interface IWorkTimeTypeService {
     public List<WorkTimeType> list ();
    
    public WorkTimeType create (WorkTimeType workTimeType);
    
    public void delete (UUID id);
    
    public WorkTimeType getById (UUID id);
    
    public WorkTimeType update (WorkTimeType workTimeType);
}
