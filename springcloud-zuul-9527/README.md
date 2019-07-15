# Spring Cloud Zuul

Zuul module works as gateway in the spring cloud project. I will load the services' names and redirect request to the correct one.

### Steps
1. Enable Zuul's function in the main file.
    ```java
    @SpringBootApplication
    @EnableZuulProxy
    public class SpringcloudZuul9527Application {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringcloudZuul9527Application.class, args);
        }
    
    }
    ```
2. Setup zuul's function in the yaml file.
    ```yml
    zuul:
      routes:   # Set up route rules
        dept.serviceId: springcloud-feign-80
        dept.path: /mydept/**
      ignored-services: '*' #springcloud-feign-80, springcloud-service-8001-hystrix, here we hide all service names and user can only visited the services with given rule.
      prefix: /seanforfun # Setup the prefix.
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

    <artifactId>springcloud-zuul-9527</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springcloud-zuul-9527</name>
    <description>Demo project for Spring Boot</description>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-zuul -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
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