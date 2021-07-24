FROM openjdk:8-jdk-alpine

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-javaagent:/dd-java-agent.jar","-jar","/app.jar"]