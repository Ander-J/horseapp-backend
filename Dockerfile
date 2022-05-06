FROM openjdk:14-jdk-alpine

EXPOSE 8080

RUN mkdir /app

COPY build/libs/backend-1.0-SNAPSHOT.jar /app/backend-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/backend-1.0-SNAPSHOT.jar"]