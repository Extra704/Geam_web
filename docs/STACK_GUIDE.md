# Stack Guide

This guide explains how to use Vue.js, Element UI, Spring Boot, MySQL, JWT, and Docker in this project, plus common pitfalls to avoid.

## 1. Vue.js

### What it is used for

- page rendering
- routing
- form interaction
- game UI logic
- API request handling

### Where it appears in this project

- `frontend/src/views/`
- `frontend/src/components/`
- `frontend/src/router/`
- `frontend/src/store/`

### Recommended usage

- Keep pages inside `views`
- Keep reusable UI inside `components`
- Put API calls in `src/api`
- Put token helpers in `src/utils/auth.js`
- Keep game state local unless many pages need it

### Things to watch out for

- Element UI is built for Vue 2, not Vue 3
- Do not mix too much business logic into components
- Keep route guards centralized
- Avoid hardcoding API base URLs in every file

## 2. Element UI

### What it is used for

- forms
- tables
- dialogs
- buttons
- cards
- menus
- notifications

### Recommended usage

- Use `el-form` for login and registration
- Use `el-table` for ranking and admin pages
- Use `el-card` for game entry cards
- Use `Message` and `MessageBox` for user feedback

### Things to watch out for

- Import the full library only for fast development
- For production optimization, consider component-based import
- Keep styles consistent and avoid mixing many UI styles

## 3. Spring Boot

### What it is used for

- RESTful API
- authentication
- service layer
- database access orchestration
- security configuration

### Backend layering in this scaffold

- `controller`: receives HTTP requests
- `service`: business logic
- `mapper`: database access
- `entity`: database model
- `dto`: request payloads
- `vo`: response payloads
- `security`: JWT and auth filters

### Recommended usage

- Keep controllers thin
- Put validation and business rules in services
- Return a unified response structure
- Keep security configuration separate from business code

### Things to watch out for

- Do not return password fields
- Validate input on register and login
- Keep exception handling centralized
- Use environment variables for secrets in production

## 4. MySQL

### What it is used for

- users
- games
- game records
- rankings or best scores

### Recommended usage

- Use `utf8mb4`
- Add indexes for ranking queries
- Store passwords as hashes only
- Separate current best score from every play record when performance matters

### Things to watch out for

- Avoid storing plaintext passwords
- Be careful with reserved keywords
- Use transaction boundaries for score update logic if needed
- Design for both history records and best-score queries

## 5. JWT

### What it is used for

- stateless login authentication
- route/API protection

### Typical flow

1. User logs in
2. Backend verifies username and password
3. Backend returns JWT
4. Frontend stores JWT
5. Frontend sends `Authorization: Bearer <token>`
6. Backend parses the token and identifies the user

### Recommended usage

- Keep token expiration reasonable
- Add a JWT filter before protected endpoints
- Parse user ID and username from token claims
- Protect admin APIs with roles

### Things to watch out for

- Do not store secrets directly in source code for production
- Token expiration handling should be clear in the frontend
- Be consistent with the `Bearer ` prefix
- Logout on the frontend usually means deleting the token

## 6. Docker

### What it is used for

- consistent local deployment
- packaging frontend and backend
- easy environment setup

### Services in this scaffold

- `mysql`
- `backend`
- `frontend`

### Recommended usage

- Backend reads DB config from environment variables
- Frontend is served by Nginx
- Use `docker compose up --build` for local full-stack boot

### Things to watch out for

- Wait for MySQL readiness before backend initialization in real projects
- Keep secrets out of public repositories
- Expose only needed ports
- Confirm cross-origin configuration when frontend and backend are split

## 7. Suggested Workflow

1. Build and test backend auth APIs
2. Connect frontend login flow
3. Build one game page
4. Connect score submission
5. Add ranking page
6. Add Docker packaging

## 8. Production Notes

- enable HTTPS
- rotate JWT secrets
- hash passwords with BCrypt
- separate dev and prod configs
- use reverse proxy and proper logging
