# Spring Cloud Config Server

![Imgur](https://i.imgur.com/wklo7Go.jpg)
This module is spring cloud config server, it connects with remote configuration file.

### Step
1. Setup the remote profile address. We also need to register the config server as a micro-service. 
```ymal
server:
  port: 3344

spring:
  application:
    name: springcloud-config-server
  cloud:
    config:
      server:
        git:
          uri: https://github.com/Seanforfun/SpringCloudConfig

eureka:
  instance:
    hostname: config-3344.com
    # instance-id: springcloud-service-1 # alias for singleton service, must close it for repeating registration
    prefer-ip-address: true # change to physical ip-addr of current service
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/, http://eureka7002.com:7002/eureka/, http://eureka7003.com:7003/eureka/ # Register a service into a cluster
    fetch-registry: true
    register-with-eureka: true
```

2. Enable the function in the main function.
```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class SpringcloudConfig3344Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfig3344Application.class, args);
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

    <artifactId>springcloud-config-3344</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springcloud-config-3344</name>
    <description>Demo project for Spring Boot</description>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-config-server -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
            <version>2.1.3.RELEASE</version>
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