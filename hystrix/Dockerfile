FROM gradle:4.7.0-jdk8-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build
RUN ls /home/gradle/src/build/libs


FROM openjdk:8-jre

EXPOSE 8888
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/hystrix.jar /app/hystrix.jar

ENTRYPOINT ["java","-jar","/app/hystrix.jar"]