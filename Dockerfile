# Build stage
FROM maven:3.8.4-openjdk-17 AS build
LABEL authors="sinehan"
COPY . .
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:17-jdk-slim
COPY --from=build /target/address-0.0.1-SNAPSHOT.jar address.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","address.jar"]
