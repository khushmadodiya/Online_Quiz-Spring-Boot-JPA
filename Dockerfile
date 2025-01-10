FROM openjdk:23-jdk
EXPOSE 8080
COPY target/quiz.jar quiz.jar
ENTRYPOINT ["java", "-jar", "/quiz.jar"]
