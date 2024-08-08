# Use the official Maven image to build the application
FROM maven:3.8.6-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files (pom.xml and src directory) into the container
COPY pom.xml ./
COPY src ./src

# Build the application and run tests
RUN mvn clean package

# Use the official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage into the container
COPY --from=build /app/target/jenkinsdockerproject-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
