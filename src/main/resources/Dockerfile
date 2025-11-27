FROM ubuntu:latest
LABEL authors="alaincis"

ENTRYPOINT ["top", "-b"]

FROM openjdk:21-jdk-slim


WORKDIR /app

COPY target/your-application.jar /app/app.jar

EXPOSE 9090

# Define the command to run your Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "/app/app.jar"]