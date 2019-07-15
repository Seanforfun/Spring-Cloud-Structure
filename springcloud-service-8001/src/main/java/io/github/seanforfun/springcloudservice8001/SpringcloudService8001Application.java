package io.github.seanforfun.springcloudservice8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableCircuitBreaker
public class SpringcloudService8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudService8001Application.class, args);
    }

}
