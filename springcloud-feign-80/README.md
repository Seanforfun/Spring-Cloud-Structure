# Spring Cloud Feign

Feign is a package that integrates the function of Ribbon and RestTemplate. We can use Feign to realize round robin load balance strategy with interface.

### Realization
1. Since the request could be called in multiple module, I put the feign interface into the springcloud-base module.
```java
@FeignClient("SPRINGCLOUD-SERVICE-8001")    // Here we define the service name.
@Service
public interface DeptService {
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    Dept get(@PathVariable("id") long id);
}
```

2. In current module, we need to update the main function.
```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"service"}) // Scan the pakage in springcloud-base
@ComponentScan(basePackages = {"io.github.seanforfun", "service"})  //Scan current module and the feign interface.
public class SpringcloudFeign80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeign80Application.class, args);
    }

}
```

3. Controller in current module, call the feign interface.
```java
@RestController
@RequestMapping("feign")
public class DeptController {

    @Autowired
    private DeptService deptService;    // Injection of feign interface. 

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id){
        return deptService.get(id); // Forward the request.
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

    <artifactId>springcloud-feign-80</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springcloud-feign-80</name>
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
            <artifactId>spring-cloud-starter-openfeign</artifactId>
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