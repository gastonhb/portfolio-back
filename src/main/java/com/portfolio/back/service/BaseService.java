package com.portfolio.back.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseService<T> implements IBaseService<T> {

    @Autowired
    public JpaRepository<T,UUID> repository;

    public BaseService(JpaRepository<T,UUID> repository) {
        this.repository = repository;
    }
    
    @Override
    public List<T> list() {
        return repository.findAll();
    }

    @Override
    public void create(T entity) {
        repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public T getById(UUID id) {
        return (T) repository.findById(id).orElse(null);
    }
    
    @Override
    public void update(T entity) {
	repository.save(entity);
    }

}
