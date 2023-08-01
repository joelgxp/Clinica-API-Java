FROM openjdk:17-alpine

WORKDIR /app
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /app/api.jar
ENTRYPOINT exec java $JAVA_OPTS -jar api.jar