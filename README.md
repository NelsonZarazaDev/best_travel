# Best Travel — Travel Reservation Backend

A Java and Spring Boot backend project exploring travel-related operations, including **flights, hotels, tours, tickets, reservations, and reporting**.

## Technology

- **Java 24**, **Spring Boot 3.5.3**, Gradle
- **Spring Data JPA** and **PostgreSQL**
- REST controllers, request/response models, validation, and exception handling
- **Spring Security / OAuth2**, **WebClient**
- **Redis / Redisson** caching, Spring Mail
- **Apache POI** for spreadsheet reporting
- OpenAPI integration, Actuator, and Docker Compose

## Repository organization

The source code is divided into API controllers and models, domain entities and repositories, services and helpers, configuration, and utilities.

Representative application areas:

| Area | Source |
| --- | --- |
| Reservations | `ReservationController`, `ReservationService` |
| Travel catalog | `FlyController`, `HotelController`, `TourController` |
| Tickets | `TicketController`, `TicketService` |
| Reporting | `ReportController`, `ExcelService` |
| Persistence | JPA entities and repositories in `domain/` |

## Local development

Requirements: **JDK 24**, Docker and Docker Compose for infrastructure, and a configured PostgreSQL instance.

```bash
git clone https://github.com/NelsonZarazaDev/best_travel.git
cd best_travel
docker compose up -d
./gradlew bootRun
```

On Windows use `gradlew.bat bootRun`.

Review `src/main/resources/application.properties` and the supporting files in `src/main/resources/configs/` before starting. Configure environment-specific endpoints and secrets locally; do not commit real credentials.

## Project status

This repository is a **portfolio/learning implementation**, not a claim of production readiness. The presence of controllers, services, and infrastructure configuration does not guarantee all integrations run without additional setup. Automated test coverage and deployment readiness require further validation.

**Author:** [Nelson Mauricio Navarro Zaraza](https://github.com/NelsonZarazaDev)
