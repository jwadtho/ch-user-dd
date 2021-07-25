FROM openjdk:8-jdk-alpine

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

COPY build/libs/*SNAPSHOT.jar app.jar

ENV DD_ENV=tootestdockerloclhost
ENV DD_SERVICE=ch-user
ENV DD_VERSION=0.1
ENV DD_LOGS_INJECTION=true
ENV DD_TRACE_DEBUG=false

LABEL "com.datadoghq.ad.logs"='[{"source":"java","service":"ch-user"}]'

CMD ["java","-javaagent:/dd-java-agent.jar","-jar","/app.jar"]


