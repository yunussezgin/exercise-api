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

- Exercise Service provides 4 endpoints to manage the exercises.
    - `/exercise/uploadCsvFile` <br>
      Upload a CSV file filled with exercises
    - `/exercise/:code` <br>
      Get an exercise with code
    - `/exercise` <br>
      Get all exercises
    - `/exercise` <br>
      Delete all exercises
- All exceptions are managed by ExceptionHandler.
- API was tested with integration and unit tests.
- Swagger UI was integrated into the API.
- DockerFile was added to the project.

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

## Example Request & Response

`REQUEST`

GET http://localhost:8080/api/exercise/271636001

`RESPONSE`
```
{
    "source": "ZIB",
    "codeListCode": "ZIB001",
    "code": "271636001",
    "displayValue": "Polsslag regelmatig",
    "longDescription": "The long description is necessary",
    "fromDate": "01-01-2019",
    "toDate": null,
    "sortingPriority": 1
}
```