FROM openjdk:8-jdk-alpine

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

COPY build/libs/*SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-javaagent:/dd-java-agent.jar","-jar","/app.jar"]