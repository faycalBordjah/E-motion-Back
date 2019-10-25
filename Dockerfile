FROM adoptopenjdk/openjdk11:latest

COPY ./target/emotion.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch emotion.jar'

ENTRYPOINT ["java","-jar","emotion.jar"]