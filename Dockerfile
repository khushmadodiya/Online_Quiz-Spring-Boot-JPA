FROM openjdk:23-jdk
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-jdk
EXPOSE 8080
COPY --from = build target/spring-boot-docker.jar .
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]