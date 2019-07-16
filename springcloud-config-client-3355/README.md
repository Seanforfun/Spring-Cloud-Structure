### Spring Cloud Config Client

![Imgur](https://i.imgur.com/wklo7Go.jpg)
Module of client will communicate with config server.  

### Steps
1. 2 configuration files
    * bootstrap.yml: this is a system level config file. Communicate with config server, the properties from current file will override the application.yml.
        ```yaml
        spring:
          cloud:
            config:
              name: springcloud-config-client
              profile: dev
              label: master
              uri: http://config-3344.com:3344 # Connect to config server.
        ```
    * application.yml: user level config file.
        ```yaml
        spring:
          application:
            name: springcloud-config-client
        ```

2. Register current service.
    ```java
    @SpringBootApplication
    @EnableDiscoveryClient
    public class SpringcloudConfigClient3355Application {
        public static void main(String[] args) {
            SpringApplication.run(SpringcloudConfigClient3355Application.class, args);
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

    <artifactId>springcloud-config-client-3355</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springcloud-config-client-3355</name>
    <description>Demo project for Spring Boot</description>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-config -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
            <version>2.1.3.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
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
