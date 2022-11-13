# Exercise API

## Tech Stack

- Java 11
- Spring Boot 2.7.5
- Maven
- H2 DB
- Lombok

## How to start the project ?

Run the below commands in the project directory.

```
mvn clean install
```

Run spring boot application.

```
mvn spring-boot:run
```

## How to start the project with Docker ?

Run the below commands in the project directory.

```
mvn clean install
```

```
docker build --tag=exercise-api:v0.0.1 .
```

```
docker run -p8080:8080 exercise-api:v0.0.1
```

## Technical Details

- Exercise Service provides 4 endpoints to manage the exercises. <br>
    - `/exercise/uploadCsvFile` <br>
      Upload a csv file filled with exercises
    - `/exercise/:code` <br>
      Get an exercise with code
    - `/exercise` <br>
      Get all exercises
    - `/exercise` <br>
      Delete all exercises

## Postman Collection

[src/main/resources/postmancollection/](src/main/resources/postmancollection/)

## Sample CSV File

[src/main/resources/data/](src/main/resources/data/)

## H2 DB INFO

- H2 DB URL: http://localhost:8080/api/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- Username: test
- Password: test

## Swagger UI URL

http://localhost:8080/api/swagger-ui/index.html
