FROM openjdk:17-jdk
COPY target/cinema-project.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
