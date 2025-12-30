#Build stage
# Find a working build with maven and java already installed
FROM maven:4.0.0-openjdk-21 AS build
# Establish the project folder as the working directory
WORKDIR /home/asankawbapp
# Copy maven and src code files
COPY pom.xml .
COPY src ./src
# Compile code into jar package
RUN mvn clean package -DskipTests

#Runtime  stage
#Create runtime image
FROM openjdk:21-jre-slim
# Set working directory
WORKDIR /asankawebapp
# Copy only the jar files
COPY --from=build /home/asankawebapp/target/*.jar app.jar
# Open port 8080 to listen for connections
EXPOSE 8080
# Run program
ENTRYPOINT ["java", "-jar", "app.jar"]

