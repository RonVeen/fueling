FROM openjdk:8-jre-alpine

COPY target/user-api-0.1-SNAPSHOT.jar /user-api.jar

EXPOSE 7000
ENTRYPOINT ["/usr/bin/java", "-jar", "/user-api.jar"]
