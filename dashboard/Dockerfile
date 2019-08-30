FROM gradle:4.7.0-jdk8-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build

RUN ls /home/gradle/src/build/libs


FROM openjdk:8-jre-slim

EXPOSE 9998
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/src.jar /app/dashboard.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/dashboard.jar"]