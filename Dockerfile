FROM openjdk:11-oracle
EXPOSE 8081
ADD target/boot-task1-0.0.1-SNAPSHOT.jar docker-app.jar
ENTRYPOINT ["java", "-jar", "docker-app.jar"]
