FROM adoptopenjdk/openjdk11:jdk-11.0.1.13-slim
MAINTAINER Turbo.az Team
COPY /target/bank_management_system-0.0.1.jar app.jar
ENTRYPOINT ["java", "-Dserver.port=8080", "-jar"]
CMD ["/app.jar"]