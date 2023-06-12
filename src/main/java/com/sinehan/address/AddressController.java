package com.sinehan.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public String demo() {
        return "404 Page not found.";
    }

    @GetMapping("/address/{empid}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("empid") int id) {
        AddressResponse addressResponse = addressService.findEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }
}
