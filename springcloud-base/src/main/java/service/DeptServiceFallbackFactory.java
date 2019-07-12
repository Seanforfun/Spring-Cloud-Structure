package service;

import entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Method;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/12 15:09
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptService> {
    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDb_source("Fallback").setDeptId(id).setDeptName("Fallback");
            }
        };
    }
}

