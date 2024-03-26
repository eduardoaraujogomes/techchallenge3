# Use a official base image
FROM openjdk:17

# Copy the jar file into the image
COPY target/techChallenge3-0.0.1-SNAPSHOT.jar techChallenge3-0.0.1-SNAPSHOT.jar

# Command to run the application
CMD ["java", "-jar", "/techChallenge3-0.0.1-SNAPSHOT.jar"]