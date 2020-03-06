FROM openjdk
ADD target/flygramp2-v1.jar flygramp2-v1.jar
EXPOSE 9595
    ENTRYPOINT ["java", "-jar", "flygramp2-v1.jar"]