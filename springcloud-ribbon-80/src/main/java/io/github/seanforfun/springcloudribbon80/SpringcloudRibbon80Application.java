package io.github.seanforfun.springcloudribbon80;

import io.github.seanforfun.ribbon.MyLoadBalanceRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "SPRINGCLOUD-SERVICE-8001", configuration = MyLoadBalanceRule.class)
public class SpringcloudRibbon80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbon80Application.class, args);
    }

}
