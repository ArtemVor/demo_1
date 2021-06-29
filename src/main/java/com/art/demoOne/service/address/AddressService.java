package com.art.demoOne.service.address;

import com.art.demoOne.model.Address;

public interface AddressService {
    Address getById(Long id);
    void save(Address address);

}
