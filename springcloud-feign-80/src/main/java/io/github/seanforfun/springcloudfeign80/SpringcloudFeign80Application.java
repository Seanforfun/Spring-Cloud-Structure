package io.github.seanforfun.springcloudfeign80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"service"})
@ComponentScan(basePackages = {"io.github.seanforfun", "service"})
@EnableCircuitBreaker
public class SpringcloudFeign80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeign80Application.class, args);
    }

}
