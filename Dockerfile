FROM maven:3.6.0 AS build
COPY src /usr/app/src
COPY pom.xml /usr/app
RUN mvn -f /usr/app/pom.xml clean install

FROM adoptopenjdk/openjdk11:latest
COPY --from=build /usr/app/target/emotion.jar /usr/local/lib/emotion.jar
WORKDIR /usr/app

ENTRYPOINT ["java","-jar","/usr/local/lib/emotion.jar"]