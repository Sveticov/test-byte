package com.svetikov.testbyte;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ServiceAddress implements ServiceAdr{
    List<AddressTest> addressTest;
    @PostConstruct
    private void init(){
        addressTest = List.of(
                new AddressTest(0,true, false, "/test 0"),
                new AddressTest(1,true, true, "/test 1"),
                new AddressTest(2,true, false, "/test 2"),
                new AddressTest(3,true, false, "/test 3"),
                new AddressTest(4,true, true, "/test 4"),
                new AddressTest(5,true, false, "/test 5")
        );
    }

    @Override
    public AddressTest getId(int id) {
        return addressTest.stream().filter(adr->adr.getIdAdr()==id)
                .findAny().get();
    }

    @Override
    public List<AddressTest> all() {
        return addressTest;
    }
}
