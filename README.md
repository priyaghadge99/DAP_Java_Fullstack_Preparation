# DAP_Java_Fullstack_Preparation
> #### Microservice : 
>
> - A microservices architecture lets teams deploy independent applications without affecting other services in the architecture. 
This feature, one of the pros of microservices, will enable developers to add new modules without redesigning the system's complete structure.
> - What is the biggest advantage of microservices?
Advantages and Disadvantages of Microservices (2023)
Some of the key engineering benefits of a microservice architecture include: Flexibility and agility. Code can be updated easily, with new features and functionalities being deployed without touching the entire application
> Due to the many benefits of the microservice architecture, a lot of companies have switched to microservices to overcome major challenges and achieve their business goals. The top real-world examples of microservices adoption are:
 Amazon — over 1000 microservices. Netflix — over 700 microservices.
> 


#### Service Discovery/ EurekaServer
1. its a Registry where all Microservice are Register
2. it will keep checking status as per time --where services are up or Down --if it goes down then it will deregisterd that service 
##### steps to Enable service Discovery
1. Add dependecy Euereka Sever
2. @EnableEurekaServer dependency at main class level
3. by befault port will be 8761 
4. http:localhost:8761  - will load eureka page


#### Api-Gateway
1. An API Gateway acts as a mediator between client applications and backend services in microservices architecture. 
2. It is a software layer that functions as a single endpoint for various APIs performing tasks such as request composition, routing, and protocol translation.
3. http://localhost:8080/anyapiname --- bydefault port is 8080 and can make call to any service using only one endpoint
4. advantage : API gateway microservices are more secure. They have an additional layer of protection from malicious API security attack vectors. Things like XML parser exploits, SQL injection, and denial-of-service (DoS) attacks. This enhanced security is among the most important benefits.
#### advantage on API-gateway
* Prevention of exposing internal concerns to external clients
* An additional layer of security for your microservices
* Support for mixing communication protocols
* Decreases microservices complexity
* Scope for microservice mocking and virtualization
  
*What is the most used API gateway?*
10 Top API Gateways and Management Tools
+ Kong Gateway.
+ Apache APISIX.
+ Tyk.
+ KrakenD.
+ Gravitee.io.
+ Apigee.
+ Amazon API Gateway.

#### Centralized Configuration management
Advantage : 
+ All microservices configuration at central place in Config server
+ If we change in configuration we dont need to restart a all service it will reflect in that services

1. Add dependecy of config server and eureka discovery client
2. Annotation of @EnableConfigServer
3. Like all Spring Boot applications, it runs on port 8080 by default, but you can switch it to the more conventional port 8888 in various ways.
4. Need a git URI for configuration  
5. spring.profile.active: native  (Configuration available on config server microservices)
6. With help of Spring.application.name : anyname  config server will identified services
7. add dependency of config client in other miroservices
8. Add location of config server using : spring.config.import : optional:configserver:http://localhost:8888  (optional meaning is if config server is down --service should run without config server as well)
------------------------------------
Generraly we dont keep all configuration on config server -- ideally it should not on config server  as it will not help us to track if any chanage made by any resource
used property like git-uri
spring.cloud.config.server.git.uri=url
spring.cloud.config.server.git.username and password

create a github repo


#### Distributed tracing
Slueth and micrometer 
Zipkin - visual respresention 
1. download zipkin server 
2. Add depencdecy distributed tracing and zipkin
  - default port for zipkin 9411
  - search localhost:9411
  - can search query after hitting service
  - tracid and spanid will genrate


*Zipkin* 
traceId: It is a unique Id assigned to the request and is the same across all the microservices.

spanId: It is a unique Id assigned to each operation(get request / put request / post request)

for eg - if we are making post request gatway->product->coupon->gateway --throuout the transaction tracid will be same for all microservices

To Check logs of health check
http://localhost:8080/actuator#

http://localhost:9000/actuator/health -- to check health of product service which is running on port :9000

we can see ciruit status is half open ---
when its giving fallback response -- bcz communication is halted as coupon services got stopped



#### Circuit breaker pattern : resilience 
Graphna and prometheous also in market

Use of the Circuit Breaker pattern 
 - can allow a microservice to continue operating when a related service fails
 - preventing the failure from cascading and giving the failing service time to recover
 -  improves application availability.
 - https://resilience4j.readme.io/docs/circuitbreaker


        -  resilience4j:
        -   circuitbreaker:
        -     instances:
        -       serviceA:
        -         registerHealthIndicator: true
        -         eventConsumerBufferSize: 10
        -         failureRateThreshold: 50
        -         minimumNumberOfCalls: 5
        -         automaticTransitionFromOpenToHalfOpenEnabled: true
        -         waitDurationInOpenState: 5s
        -         permittedNumberOfCallsInHalfOpenState: 3
        -         slidingWindowSize: 10
        -         slidingWindowType: COUNT_BASED 
        - 
        -  management:
        -    health:
        -      circuitbreakers:
        -        enabled: true
        -    endpoints:
        -      web:
        -        exposure:
        -          include: health
        -    endpoint:
        -      health:
        -       show-details: always	

    - https://www.geeksforgeeks.org/spring-boot-actuator/
    web.exposure.include =* for all info
    endpoint.health.showdetail = always --inorder to see detail information of health by defalut value is never
    - failureRateThreshold: Configures the failure rate threshold in percentage. When the failure rate is equal or greater than the threshold the CircuitBreaker transitions to open and starts short-circuiting calls.     

    - minimumNumberOfCalls : , if minimumNumberOfCalls is 10, then at least 10 calls must be recorded, before the failure rate can be calculated.
If only 9 calls have been recorded the CircuitBreaker will not transition to open even if all 9 calls have failed.
    - waitDurationInOpenState :  The time that the CircuitBreaker should wait before transitioning from open to half-open.  
    - slidingWindowSize : Configures the size of the sliding window which is used to record the outcome of calls when the CircuitBreaker is closed.     


Add dependecy
Circuit breaker

@Annotation @methhod level where communication to other service is there
@CircuitBreaker(name = "serviceA", fallbackMethod = "fallbackMethod")

//fallback behavior when service getting failed to respond
	public Product fallbackMethod(Exception e) {
		return new Product();
	}
https://www.markdownguide.org/basic-syntax/    