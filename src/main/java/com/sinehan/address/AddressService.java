package com.sinehan.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    public AddressResponse findEmployeeById(int id) {
        Address address = addressRepository.findAddressByEmployeeId(id);
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setLane1(address.getLane1());
        addressResponse.setLane2(address.getLane2());
        addressResponse.setState(address.getState());
        addressResponse.setZip(address.getZip());
        return addressResponse;
    }
}
