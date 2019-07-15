package io.github.seanforfun.springcloudservice8001.controller;

import entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/11 14:00
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@RestController
public class ConsumerController {

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/id/{id}")
    public Dept get(@PathVariable("id") long id){
        Dept dept = new Dept();
        dept.setDeptId(id);
        dept.setDb_source("database_01");
        dept.setDeptName(environment.getProperty("local.server.port"));
        return dept;
    }
}
