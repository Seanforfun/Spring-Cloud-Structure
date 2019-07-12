package service;

import entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/12 13:14
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@FeignClient("SPRINGCLOUD-SERVICE-8001")
@Service
public interface DeptService {

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    Dept get(@PathVariable("id") long id);

}
