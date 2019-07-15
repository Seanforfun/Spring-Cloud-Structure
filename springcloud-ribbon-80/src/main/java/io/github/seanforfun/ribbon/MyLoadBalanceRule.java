package io.github.seanforfun.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/12 12:18
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@Configuration
public class MyLoadBalanceRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
