
package com.portfolio.back.service;

import java.util.List;
import java.util.UUID;

public interface IBaseService <T>{
    
    public List<T> list ();
    
    public void create (T entity);
    
    public void delete (UUID id);
    
    public T getById (UUID id);
    
    public void update (T entity);
}
