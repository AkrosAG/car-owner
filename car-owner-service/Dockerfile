FROM maven:3.6.3-jdk-11 AS builder
WORKDIR /usr/local/app/car-owner-service

COPY ./car-owner-service/pom.xml ./
RUN mvn dependency:go-offline

COPY ./car-owner-service/ ./
RUN mvn clean package

FROM openjdk:11-jre-slim AS deploy

EXPOSE 8080 8080

COPY --from=builder /usr/local/app/car-owner-service/target/car-owner-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app.jar"]