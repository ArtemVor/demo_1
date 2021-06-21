package com.art.demoOne.service.address;

import com.art.demoOne.model.Address;
import com.art.demoOne.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid address id " + id));
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }
}
