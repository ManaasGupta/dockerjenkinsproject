# Use the official OpenJDK 17 image as the base
FROM openjdk:17-jdk-slim AS build

# Install Maven 3.9.6
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz && \
    tar xzf apache-maven-3.9.6-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.9.6 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files (pom.xml and src directory) into the container
COPY pom.xml ./
COPY src ./src

# Build the application and run tests
RUN mvn clean test verify

# Use the official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage into the container
COPY --from=build /app/target/jenkinsdockerproject-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 9090

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

