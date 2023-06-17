FROM ubuntu:latest
LABEL authors="joelv"

WORKDIR /app

COPY target/*.jar app.jar

ENTRYPOINT ["top", "-b"]