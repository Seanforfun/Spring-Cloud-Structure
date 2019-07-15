# Spring Cloud Ribbon

This module integrated ribbon as a costumer side load balancer. Ribbon is registered to eureka server as a micro-service and it will forward requests to registered micro-services with same service name by its load balance strategy.

### RestTemplate for REST api
```java
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced   // Define current restTemplate is load balanced. Required if multiple instances with same service name is registered.
    public RestOperations restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
    
     @Bean
    public IRule customizedRule(){ // customized load balance strategy.
        return new RoundRobinRule();
    }
}
``` 

### Customized Load Balance Strategy
1. Add @RibbonClient at main start class.
```java
@RibbonClient(name = "SPRINGCLOUD-SERVICE-8001", configuration = MyLoadBalanceRule.class)
```
2. Create customized load balance strategy class. Must not at the package of main class!
```java
@Configuration
public class MyLoadBalanceRule {    // we can customized our rule by extends AbstractLoadBalancer
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
```

### pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>io.github.seanforfun</groupId>
        <artifactId>springcloud</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <artifactId>springcloud-ribbon-80</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springcloud-ribbon-80</name>
    <description>Demo project for Spring Boot</description>

    <dependencies>
        <dependency>
            <groupId>io.github.seanforfun</groupId>
            <artifactId>springcloud-base</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
            <version>2.1.2.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```