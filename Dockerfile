# Use an official OpenJDK image
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy your source code into the container
COPY src/Cube.java .

# Compile the Java file
RUN javac Cube.java

# Run the application
CMD ["java", "Cube"]