FROM openjdk:17-jdk-slim AS build

RUN apt-get update && apt-get install -y wget && apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw

RUN ./mvnw dependency:go-offline
RUN ./mvnw clean test verify

COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build /app/target/jenkinsdockerproject-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]
