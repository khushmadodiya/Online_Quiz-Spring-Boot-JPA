

FROM openjdk:23-jdk
EXPOSE 8080
ADD target/quiz.jar quiz.jar
ENTRYPOINT ["java","-jar","/quiz.jar"]