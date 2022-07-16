FROM openjdk:18-ea-11-jdk-alpine3.15

COPY . /app

WORKDIR /app

RUN ./mvnw -B package -DskipTests=true

EXPOSE 8080

CMD ["./mvnw", "spring-boot:run"]