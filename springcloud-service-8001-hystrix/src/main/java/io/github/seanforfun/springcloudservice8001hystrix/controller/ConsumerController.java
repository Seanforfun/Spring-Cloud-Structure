package io.github.seanforfun.springcloudservice8001hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;

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

    private int count = 0;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
//    @HystrixCommand(fallbackMethod = "getFallBack")
    public Dept get(@PathVariable("id") long id){
        if(count++ % 2 == 1) throw new RuntimeException();
        Dept dept = new Dept();
        dept.setDeptId(id);
        dept.setDb_source("database_01");
        dept.setDeptName(environment.getProperty("local.server.port"));
        return dept;
    }

    private Dept getFallBack(@PathVariable("id") long id){
        return new Dept().setDb_source("Fallback").setDeptId(id).setDeptName("Fallback");
    }
}
