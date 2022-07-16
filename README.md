# spring-sample

Service powered by Java Spring Boot 

## There are three assignments solved in this project
1. Hospital Reception Service
```text
Problem: Implement a Hospital class which admits patients into a hospital. 
The Hospital interface has a single public method, admitOne, which simply prints the name of the patient admitted into the hospital 
and a timestamp of when he or she was admitted, based on the requirements described below.

Requirements
● Implement the admitOne method of the Hospital interface. 
    admitOne should print a log message with a timestamp and the name of the patient when that patient is 
    finally admitted into the Hospital.
● Because there is only one receptionist, you can only admit one patient into the hospital every 5 seconds. 
    For example, if admitOne is called three times (in parallel), it should take ~10 seconds for all three 
    people to be admitted into the hospital. (patient 1 admitted at T-0, patient 2 admitted at T-5, and 
    patient 3 admitted at T-10)
● Admittance to the hospital should be first-come-first-serve. In other words, patients should be admitted 
    in the same order that admitOne was called in.
```
2. Players ingestion and retrieval service
```text
Problem: Create a microservice which serves the contents of Player.csv through a REST API.
   The service should expose two REST endpoints:
   ● GET /api/players - returns the list of all players.
   ● GET /api/players/{playerID} - returns a single player by ID.
```
3. User Create/Read APIs
```text
Problem: Create Create and Read APIs for an User. Create API should add entry in database.
Read API should read the entry from database
```

## System requirements
- MacOS (for development)
- Java 11
- Docker

## Run Elasticsearch locally in Docker container:
```shell
docker run -d --name elasticsearch \
-p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" \
docker.elastic.co/elasticsearch/elasticsearch:7.9.0
```

## Run Unit and Integration tests
```shell
./mvnw clean test -s .mvn/wrapper/settings.xml
```

## Build Java docs
```shell
./mvnw clean javadoc:javadoc
```

## Start Application locally
```shell
./mvnw clean install -D skipTests = true -s .mvn/wrapper/settings.xml
```
```shell
./mvnw spring-boot:run
```

## Start Application locally in Docker (Alternative way to package and run application)
```shell
docker build -t sample-app:latest .
```
```shell
docker run -d -p 8080:8080 --name sample-app-container sample-app:latest
```

## Swagger-doc url
[http://localhost:8080/api/v1/spring-sample/swagger-ui.html](http://localhost:8080/api/v1/spring-sample/swagger-ui.html)