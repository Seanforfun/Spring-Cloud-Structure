package io.github.seanforfun.springcloudeurekaserver7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurekaServer7002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaServer7002Application.class, args);
    }

}
