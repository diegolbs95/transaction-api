FROM maven:3.8.5-openjdk-17 AS build

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
RUN mvn package

FROM azul/zulu-openjdk:17
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY --from=build /usr/src/app/target/transaction-0.0.1-SNAPSHOT.jar app.jar
COPY --from=build /usr/src/app/target/classes/application-prd.yml ./application.properties

CMD ["java", "-jar", "app.jar"]
