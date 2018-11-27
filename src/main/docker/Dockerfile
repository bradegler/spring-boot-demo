FROM openjdk:8-jre-alpine
LABEL maintainer Brad Egler <brad.egler@oracle.com>

RUN mkdir -p /opt/app/ 
RUN  addgroup spring && \
  adduser -S spring spring && \
  echo spring: | chpasswd && \
  chown -R spring:spring /opt/

USER spring
COPY *.jar /opt/app/server.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/app/server.jar"]
