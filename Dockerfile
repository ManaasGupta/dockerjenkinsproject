# Start with a base image containing Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Add Maintainer Info
LABEL maintainer="manasgpt3@gmail.com"

EXPOSE 9090

# The application's jar file
ARG JAR_FILE=target/jenkinsdockerproject-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} jenkinsdockerproject.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/jenkinsdockerproject.jar"]