FROM gradle:4.7.0-jdk8-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build --no-daemon

RUN ls /home/gradle/src/build/libs


FROM openjdk:8-jre-slim

EXPOSE 8888
RUN mkdir /app
RUN ls /app
COPY --from=build /home/gradle/src/build/libs/hystrix.jar /app/hystrix.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/hystrix.jar"]