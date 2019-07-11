package io.github.seanforfun.springcloudeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurekaServer7001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaServer7001Application.class, args);
    }

}
