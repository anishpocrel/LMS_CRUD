FROM openjdk:11
ADD target/lms-learn.jar lms-learn.jar
ENTRYPOINT ["java", "-jar", "lms-learn.jar"]