FROM openjdk:17-alpine

WORKDIR /app

COPY out/artifacts/api_jar/api.jar /app/api.jar

RUN bash -c 'touch /app/api.jar'

ENTRYPOINT ["java", "-jar", "api.jar"]