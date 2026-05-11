# Geam Web

`Geam Web` is a full-stack scaffold for a small game platform built with Vue.js, Element UI, Spring Boot, MySQL, JWT, and Docker.

It is designed for projects such as quiz games, memory games, click-speed games, or simple ranking-based mini games.

## Stack

- Frontend: Vue 2, Vue Router, Vuex, Element UI, Axios
- Backend: Spring Boot 3, Spring Security, JWT, MyBatis-Plus
- Database: MySQL 8
- Deployment: Docker, Docker Compose, Nginx

## Features Included

- User registration and login
- JWT authentication
- Game list and game detail API
- Score submission and ranking API
- Basic admin-facing API layout
- Database schema starter
- Frontend route and state management starter
- Dockerized local deployment
- Tooling and usage guide

## Project Structure

```text
Geam_web/
  frontend/
  backend/
  sql/
  docs/
  docker-compose.yml
```

## Quick Start

### 1. Start MySQL

Create a database named `geam_web`.

Run:

```sql
SOURCE sql/schema.sql;
```

### 2. Configure Backend

Edit:

`backend/src/main/resources/application.yml`

Set your MySQL username, password, and JWT secret.

### 3. Run Backend

```bash
cd backend
mvn spring-boot:run
```

Backend default:

`http://localhost:8080/api`

### 4. Run Frontend

```bash
cd frontend
npm install
npm run serve
```

Frontend default:

`http://localhost:8081`

### 5. Run with Docker

```bash
docker compose up --build
```

## Suggested Development Order

1. Finish authentication first
2. Connect frontend login and registration
3. Implement one mini game page
4. Submit scores to backend
5. Add ranking page
6. Add admin pages if needed
7. Package with Docker

## Recommended First Game

The easiest first implementation is a quiz or reaction game because it cleanly demonstrates:

- frontend interaction
- REST API
- score persistence
- ranking queries

## Docs

- Tooling and usage guide: [docs/STACK_GUIDE.md](./docs/STACK_GUIDE.md)
- SQL schema: [sql/schema.sql](./sql/schema.sql)

## Notes

- This scaffold focuses on clean project structure and integration points.
- Some business logic is intentionally left simple so you can customize the actual game rules.
