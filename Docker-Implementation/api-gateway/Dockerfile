FROM openjdk:17
COPY ./target/api-gateway-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/api-gateway-0.0.1-SNAPSHOT.jar"]


#FROM eclipse-temurin:17.0.4.1_1-jre as builder
#WORKDIR extracted
#ADD target/*.jar api-gateway-0.0.1-SNAPSHOT.jar
#RUN java -Djarmode=layertools -jar api-gateway-0.0.1-SNAPSHOT.jar extract

#FROM eclipse-temurin:17.0.4.1_1-jre
#WORKDIR application
#COPY --from=builder extracted/dependencies/ ./
#COPY --from=builder extracted/spring-boot-loader/ ./
#COPY --from=builder extracted/snapshot-dependencies/ ./
#COPY --from=builder extracted/application/ ./
#EXPOSE 8080
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]