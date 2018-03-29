package com.tigerbrokers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DcController {

    private static Logger log = LoggerFactory.getLogger(DcController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        try {
            int sleepTime = new Random().nextInt(3000);
            log.info("sleepTime:" + sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            log.error("dc {}", e.getMessage());
        }
        return services;
    }

}
