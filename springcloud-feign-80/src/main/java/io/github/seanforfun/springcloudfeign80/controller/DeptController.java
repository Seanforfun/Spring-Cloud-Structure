package io.github.seanforfun.springcloudfeign80.controller;

import entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.DeptService;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/12 13:19
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@RestController
@RequestMapping("feign")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id){
        return deptService.get(id);
    }
}
