package com.svetikov.testbyte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdrController {
    @Autowired
    ServiceAdr serviceAdr;
    @GetMapping("/adr/{id}/{statusPLC}")
    public ResponseEntity<AddressTest> idGet(@PathVariable int id,@PathVariable boolean statusPLC){
        AddressTest addressTest=serviceAdr.getId(id);
        addressTest.setPlcAdr(statusPLC);
        return ResponseEntity.ok(addressTest);
    }
}
