FROM maven:3.8.6-jdk-11 AS builder
WORKDIR /usr/local/app/car-owner-service

COPY ./pom.xml ./
RUN mvn dependency:go-offline

COPY ./ ./
RUN mvn clean package

FROM eclipse-temurin:11-alpine AS deploy

EXPOSE 8080 8080

COPY --from=builder /usr/local/app/car-owner-service/target/car-owner-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app.jar"]