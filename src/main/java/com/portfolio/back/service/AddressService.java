package com.portfolio.back.service;

import com.portfolio.back.exception.ResourceNotFoundException;
import com.portfolio.back.model.Address;
import com.portfolio.back.repository.AddressRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {

   @Autowired
    public AddressRepository  repository;
    
    @Override
    public List<Address> list() {
        return repository.findAll();
    }

    @Override
    public Address create(Address address) {
        return repository.save(address);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Address getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address", "id", id));
    }
    
    @Override
    public Address update(Address address) {
	return repository.save(address);
    }
    
}
