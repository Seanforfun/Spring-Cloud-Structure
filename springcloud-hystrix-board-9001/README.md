# Spring Cloud Hystrix Dashboard

Hystrix dashboard is a tool to monitor micro-services' condition and status.

### Steps
1. Create a module of hystrix board, add hystrix board dependencies to pom.
2. Enable Hystrix dashboard by annotation.
    ```java
    @SpringBootApplication
    @EnableHystrixDashboard
    public class SpringcloudHystrixBoard9001Application {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringcloudHystrixBoard9001Application.class, args);
        }
    
    }
    ```
3. Enable the application to be monitored. If current micro-service has multiple instances, enable the monitoring service on its load balancer.
    ```java
    @SpringBootApplication
    @EnableDiscoveryClient
    @EnableFeignClients(basePackages = {"service"})
    @ComponentScan(basePackages = {"io.github.seanforfun", "service"})
    @EnableCircuitBreaker
    public class SpringcloudFeign80Application {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringcloudFeign80Application.class, args);
        }    
    }
    ```
4. The most important part: Since the hystrix.stream is provided by dependency actuator, we must enable it in its yaml file.
    ```yml
    management:
      endpoints:
        web:
          exposure:
            include: ['hystrix.stream','info','health']
    ```
5. Go to hystrix dashboard main page: http://{ipaddr}:{port}/hystrix
![Imgur](https://i.imgur.com/SDhj4Yz.png)
6. Monitor the stream.
![Imgur](https://i.imgur.com/sl7Vi73.png)
    * Different colors means the response status of a request.
    * Size of the circle means the current volume. 

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

    <artifactId>springcloud-hystrix-board-9001</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springcloud-hystrix-board-9001</name>
    <description>Demo project for Spring Boot</description>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-hystrix -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
            <version>2.1.2.RELEASE</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-hystrix-dashboard -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
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