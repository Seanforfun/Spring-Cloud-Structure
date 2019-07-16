package io.github.seanforfun.springcloudconfig3344;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class SpringcloudConfig3344Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfig3344Application.class, args);
    }

}
