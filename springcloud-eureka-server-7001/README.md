# Spring Cloud Eureka Server

This module is a demo for eureka server. We have three serves registered in current replica, which are springcloud-eureka-server-7001, springcloud-eureka-server-7002 and springcloud-eureka-server-7003.

### [pom.xml](https://github.com/Seanforfun/Spring-Cloud-Structure/blob/master/springcloud-eureka-server-7001/pom.xml)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>    <!-- Locate the parent -->
        <groupId>io.github.seanforfun</groupId>
        <artifactId>springcloud</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <artifactId>springcloud-eureka-server-7001</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springcloud-eureka-server-7001</name>
    <description>Demo project for Spring Boot</description>

    <dependencies>
        <dependency>    <!-- Import base module -->
            <groupId>io.github.seanforfun</groupId>
            <artifactId>springcloud-base</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

        <dependency>    <!-- Dependency for eureka server -->
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
            <version>2.1.2.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### [application.yml](https://github.com/Seanforfun/Spring-Cloud-Structure/blob/master/springcloud-eureka-server-7001/src/main/resources/application.yml)
```yml
server:
  port: 7001

eureka:
  instance:
    hostname: eureka7001.com
  client:
    register-with-eureka: false # Register center doesn't need to register itself
    fetch-registry: false # Register center doesn't need to fetch service
    service-url:
defaultZone: http://eureka7002.com:7002/eureka/, http://eureka7003.com:7003/eureka/ # discover other servers in the cluster
```