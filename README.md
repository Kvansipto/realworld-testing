# RealWorld API Testing Project

This repository contains system-level automated tests for the RealWorld Example API.

System under test:  
https://github.com/gothinkster/spring-boot-realworld-example-app

The goal of this project is to practice **system analysis, risk identification, and test strategy design** for a REST API backend.

This repository complements the backend project by adding **system API tests and concurrency tests**.

---

# System Under Test (SUT)

RealWorld Example App is a synchronous REST API application.

**Key characteristics**

- Architecture: layered monolith
- Communication: HTTP request–response
- Application state: stateless service
- Data persistence: PostgreSQL
- Consistency model: ACID transactions
- Deployment model: single service

**Domain entities**

- User
- Article
- Comment
- Tag
- Favorite
- Follow

---

# Architecture of SUT


      Client
        │
        ▼
    REST API (Controllers)
        │
        ▼
    Service layer
        │
        ▼
    Repository layer
        │
        ▼
    PostgreSQL


---
# Existing Test Coverage (Backend Project)

The backend repository already contains tests at the following levels.

### Unit tests
- domain logic (e.g. slug generation)
- utility services (JWT handling)

### Repository integration tests
- repository ↔ PostgreSQL integration
- SQL mapping
- transaction rollback behavior

### Service integration tests
- query services
- pagination logic
- filtering logic
- feed generation

### Controller slice tests
- request validation
- authentication
- HTTP contract

The backend project **does not contain system-level API tests** that verify the full request flow.

---

# Risk Analysis

### Data integrity

- `favorites_count` may diverge from the actual number of favorites due to incorrect counter updates
- inconsistent follow relationships (duplicate follows or broken follow state)

### Authorization

- editing another user's article
- deleting another user's comment
- accessing the personalized feed without authentication

### Concurrency

- concurrent favorite operations causing incorrect favorites count
- concurrent follow operations creating duplicate relationships

### System behavior

- incorrect article lifecycle behavior (create → update → delete)
- personalized feed showing incorrect articles after follow/unfollow operations

---

# Test Scope

This repository focuses on **system-level testing of the RealWorld API**.

### System API tests

Verify the complete request flow:

HTTP → Controller → Service → Repository → Database


These tests validate:

- endpoint behavior
- authentication
- authorization
- data persistence
- response structure

### Concurrency tests

Verify correctness under concurrent operations.

Example scenarios:

- concurrent favorites
- concurrent follow operations

---

# Test Strategy

Unit tests → Repository integration tests → Service integration tests → System API tests

---

# Example Test Scenarios

Examples of system-level scenarios covered by tests:

- user registration
- user login
- article creation
- article update
- article deletion
- favoriting and unfavoriting articles
- following and unfollowing users
- retrieving personalized feed
- authorization checks

Concurrency scenarios:

- multiple users favoriting the same article simultaneously
- concurrent follow operations

---

# Test Environment

- Java 17
- Docker
- PostgreSQL
- Testcontainers

---

# CI Strategy

The CI pipeline runs:

1. Backend tests (unit and integration)
2. System API tests from this repository

System API tests are configured as a **blocking quality gate**.