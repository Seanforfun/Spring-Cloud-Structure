# Spring-Cloud-Structure
A general structure for Spring Cloud.

### Introduction
This is a repository including the basement of spring cloud project. I realized the basic configuration of a spring cloud project and future function can be easily added to this repository.

### [pom.xml](https://github.com/Seanforfun/Spring-Cloud-Structure/blob/master/pom.xml)
Packaging is pom. Create the basic dependencies.

### [springcloud-base](https://github.com/Seanforfun/Spring-Cloud-Structure/tree/master/springcloud-base) 
Module for including general apis and classes for rest of the modules. 

### [springcloud-eureka-server-700*](https://github.com/Seanforfun/Spring-Cloud-Structure/tree/master/springcloud-eureka-server-7001)
Eureka server clusters, where micro-services are registered to the servers. Realized service register and discovery.

### [springcloud-service-800*](https://github.com/Seanforfun/Spring-Cloud-Structure/tree/master/springcloud-service-8001) 
A simple micro-service.

### [springcloud-ribbon-80](https://github.com/Seanforfun/Spring-Cloud-Structure/tree/master/springcloud-ribbon-80)
Client side load balancer. We can customize our load balance strategy in this module.

