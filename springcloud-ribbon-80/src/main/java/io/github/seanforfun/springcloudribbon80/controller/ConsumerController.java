package io.github.seanforfun.springcloudribbon80.controller;

import entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/11 13:52
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@RestController
@RequestMapping("ribbon")
public class ConsumerController {
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-SERVICE-8001";

    @Autowired
    private RestOperations restTemplate;

    @RequestMapping(value = "/id/{id}")
    public Dept get(@PathVariable("id") long id){
        return restTemplate.getForObject( REST_URL_PREFIX + "/id/{id}", Dept.class, id);
    }
}
