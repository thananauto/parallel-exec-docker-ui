FROM maven:3.6.3-jdk-11 
WORKDIR /app 
COPY pom.xml . 
COPY src ./src
CMD ["mvn", "clean", "test"]