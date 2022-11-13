FROM openjdk:11
ADD target/exercise-api-0.0.1-SNAPSHOT.jar exercise-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/exercise-api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080