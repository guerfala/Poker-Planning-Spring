FROM openjdk:17
EXPOSE 8082
ADD target/pokerr-0.0.1.jar /pokerr-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/pokerr-0.0.1.jar"]