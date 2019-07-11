# Spring Cloud Service

This is a demo micro-service module. No function is implemented here. We registered this module as a client of the eureka server.

### [pom.xml](https://github.com/Seanforfun/Spring-Cloud-Structure/blob/master/springcloud-service-8001/pom.xml)
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

    <artifactId>springcloud-service-8001</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springcloud-service-8001</name>
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
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

### [application.yml](https://github.com/Seanforfun/Spring-Cloud-Structure/blob/master/springcloud-service-8001/src/main/resources/application.yml)
```yml
server:
  port: 8001

eureka:
  instance:
    hostname: localhost
    instance-id: springcloud-service-1 # alias for current service
    prefer-ip-address: true # change to physical ip-addr of current service
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/ # Register a service into a cluster
    fetch-registry: true
    register-with-eureka: true

spring:
  application:
    name: springcloud-service-8001
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql://127.0.0.1:3306/${spring.application.name}
    username: root
    password: 123456
    dbcp2:
      min-idle: 5
      initial-size: 5
      max-total: 5
      max-wait-millis: 200

info:
  app.name: springcloud-service
  company.name: seanforfun.github.io
  build.artifactId: @project.artifactId@
  build.version: @project.version@
  port: ${server.port}
```