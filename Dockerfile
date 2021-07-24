FROM openjdk:8-jdk-alpine

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

ADD build/libs/user-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-javaagent:/dd-java-agent.jar","-jar","/app.jar"]