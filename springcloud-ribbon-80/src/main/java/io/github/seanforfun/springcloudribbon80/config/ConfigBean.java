package io.github.seanforfun.springcloudribbon80.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/11 13:49
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestOperations restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public IRule customizedRule(){
        return new RoundRobinRule();
    }

}
