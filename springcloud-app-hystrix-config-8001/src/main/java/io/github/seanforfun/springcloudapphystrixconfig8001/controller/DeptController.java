package io.github.seanforfun.springcloudapphystrixconfig8001.controller;

import entities.Dept;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/16 12:32
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@RestController
public class DeptController {
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id){
        return new Dept("Local", id, "db_" + id);
    }
}
