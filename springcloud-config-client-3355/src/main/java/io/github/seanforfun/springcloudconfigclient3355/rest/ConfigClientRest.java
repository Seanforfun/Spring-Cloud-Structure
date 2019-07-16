package io.github.seanforfun.springcloudconfigclient3355.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/16 10:41
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@RestController
public class ConfigClientRest {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("application name: " + this.applicationName + "\n");
        stringBuilder.append("eureka server: " + this.eurekaServers + "\n");
        stringBuilder.append("server port: " + this.port + "\n");
        return stringBuilder.toString();
    }
}
