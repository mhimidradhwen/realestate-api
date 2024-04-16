# Use an official OpenJDK runtime as the base image
FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ./target/realestate-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java","jar","/app.jar" ]