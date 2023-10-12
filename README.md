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


