FROM openjdk:17-jdk-alpine

COPY out/measurement.jar app/measurement.jar
COPY lib/ /lib/