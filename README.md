# Reclamations — Complaints Service

Manages user **complaints / support tickets** for Money Minder MS.

## Tech stack
Java · Spring Boot · Spring Data JPA · MySQL · Spring Cloud (Eureka, Config) · RabbitMQ (AMQP) · springdoc-openapi

## API — port `8082`
Base path `/api/reclamations` with full CRUD. Swagger UI at `/swagger-ui.html`.

## Data & messaging
MySQL `gestion_reclamation` (port 3307) · publishes events over RabbitMQ.

## Run
```bash
mvn spring-boot:run
```

## Configuration
Settings live in `src/main/resources/application.properties`. Override the database and RabbitMQ credentials with environment variables outside local development.

## Part of Money Minder MS

One service of the **Money Minder MS** Spring Cloud platform. Full architecture and
the other services: [API-Gateway README](https://github.com/Money-Minder-MS/API-Gateway).
Start EurekaServer (8761) and Config-Server (8099) first.

