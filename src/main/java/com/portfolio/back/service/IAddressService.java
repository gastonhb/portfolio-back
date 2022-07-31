package com.portfolio.back.service;

import com.portfolio.back.model.Address;
import java.util.List;
import java.util.UUID;

public interface IAddressService {
    
    public List<Address> list ();
    
    public Address create (Address address);
    
    public void delete (UUID id);
    
    public Address getById (UUID id);
    
    public Address update (Address address);
    
}
