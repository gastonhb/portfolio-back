package com.portfolio.back.service;

import com.portfolio.back.model.Address;
import com.portfolio.back.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address> implements IAddressService {

    public AddressService(AddressRepository repository) {
        super(repository);
    }
    
}
