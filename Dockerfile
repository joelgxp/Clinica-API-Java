FROM openjdk:17-alpine

WORKDIR /app
ENV PORT 9001
EXPOSE 9001
COPY target/*.jar /app/api.jar
ENTRYPOINT exec java $JAVA_OPTS -jar api.jar