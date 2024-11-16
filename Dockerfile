FROM eclipse-temurin:17-jdk-alpine
ENV TZ=Europe/Athens
WORKDIR /app/
COPY target/bank-*-runner.jar bank-runner.jar
EXPOSE 8080
VOLUME logs
ENTRYPOINT ["java", "-jar", "bank-runner.jar"]