# Shopping_Portal

Author - Deep Parmar

## Project quick read

This repository contains a Spring Boot 3.2.3 + Thymeleaf shopping/admin portal app under `Shopping_Portal/`.

### Tech stack
- Java 17
- Spring Boot (Web, Security, Data JPA, Thymeleaf)
- MySQL connector
- Thymeleaf layout dialect + Spring Security extras

### Key backend flow
- Security is configured with form login at `/login`, success redirect to `/index`, and a custom `UserDetailsService` using the `Admin` table.
- Signup endpoints (`/signup`, `/registerUser`) are public.
- Admin rows are saved in the `Admin` JPA entity with audit fields (`createdBy`, `createdDate`, `modifiedBy`, `modifiedDate`).
- A REST endpoint (`/admin/retrive`) returns paginated data for admin table UI in DataTables-style shape.

### Main package layout (`Shopping_Portal/src/main/java/com/shopping/project`)
- `config/` – security, custom user details, auditor provider
- `controller/` – MVC controllers for login/signup/index/admin pages
- `restcontroller/` – JSON endpoint for admin table retrieval
- `entity/` – JPA entities + AJAX DTO
- `repository/` – Spring Data repository
- `service/` – service layer wrapping repository calls

### Configuration notes
`application.properties` currently expects a local MySQL instance:
- `server.port=9082`
- `spring.datasource.url=jdbc:mysql://localhost:3306/shopping_db`
- username: `root`
- password: `deep`
- `spring.jpa.hibernate.ddl-auto=update`

If you run this project in a fresh environment, create the DB and update credentials before starting.
