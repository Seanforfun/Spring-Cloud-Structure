package io.github.seanforfun.springcloudhystrixboard9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringcloudHystrixBoard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudHystrixBoard9001Application.class, args);
    }

}
