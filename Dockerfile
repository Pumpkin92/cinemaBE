FROM openjdk:17-jdk
WORKDIR /app
COPY target/cinema-project-0.0.1-SNAPSHOT.jar.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]

