# Spring Cloud Hystrix

Hystrix is a module used to do curcuit break and service downgrade.

### Curcuit Break
Micro service allows us to have a reference chain between services. If any one of the services is down, it will cause a huge problem to the system( we call it snow crash). Here we use curcuit breaker Hystrix to give it a fallback method in replace.

#### Implementation
1. Enable the hystrix
```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class SpringcloudService8001HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudService8001HystrixApplication.class, args);
    }

}
```
2. Realize the hystrix.
```java
@RestController
public class ConsumerController {

    @Autowired
    private Environment environment;

    private int count = 0;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getFallBack") // register the fallback method.
    public Dept get(@PathVariable("id") long id){
        if(count++ % 2 == 1) throw new RuntimeException();  // create a environment to throw exception.
        Dept dept = new Dept();
        dept.setDeptId(id);
        dept.setDb_source("database_01");
        dept.setDeptName(environment.getProperty("local.server.port"));
        return dept;
    }

    private Dept getFallBack(@PathVariable("id") long id){  // Give the fallback method.
        return new Dept().setDb_source("Fallback").setDeptId(id).setDeptName("Fallback");
    }
}
```

### Service degrade(reduce code dilation with AOP, service down handler)
Service degrade is a way to pause a single service. We can use hystrix to realize this function.

1. Feign side provide fallback methods, here we provide a fallback factory.
```java
@FeignClient(value = "SPRINGCLOUD-SERVICE-8001-HYSTRIX", fallbackFactory = DeptServiceFallbackFactory.class)
@Service
public interface DeptService {

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    Dept get(@PathVariable("id") long id);

}
```

2. Create a fallback factory to implement the fallback handler.
```java
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptService> {
    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDb_source("Fallback").setDeptId(id).setDeptName("Fallback");
            }
        };
    }
}
```
3. When micro-service is stopped, hystrix will call the fallback handlers. 

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

    <artifactId>springcloud-service-8001-hystrix</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springcloud-service-8001-hystrix</name>
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