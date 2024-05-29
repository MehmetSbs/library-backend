FROM maven:3.8.4-openjdk-21 AS build
LABEL maintainer="fume"
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:21
EXPOSE 8080
COPY --from=build /app/target/Library-Backend-1.jar /app/librarybackend.jar
ENTRYPOINT ["java", "-jar", "/app/librarybackend.jar"]