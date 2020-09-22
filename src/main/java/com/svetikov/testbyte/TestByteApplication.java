package com.svetikov.testbyte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class TestByteApplication implements CommandLineRunner {
    @Autowired
    ServiceAdr serviceAdr;

    public static void main(String[] args) {
        SpringApplication.run(TestByteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }

    @Scheduled(initialDelay = 5000, fixedRate = 5000)
    public void testScheduled() {
        log.info("start scheduled");
        serviceAdr.all().stream()
                .filter(adr -> {
                    boolean status = adr.isPlcAdr();
                    if (status & adr.isStatusAdr()) {
                        adr.setStatusAdr(!status);
                        return status;
                    }
                    if (!status & !adr.isStatusAdr())
                        adr.setStatusAdr(!status);
                    return false;
                })
                .forEach(adr ->
                        log.info(adr.getMessageAdr())
                );
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class AddressTest {
    private int idAdr;
    private boolean statusAdr;
    private boolean plcAdr;
    private String messageAdr;
}