# Expense Tracker Backend (Spring Boot)

## 📌 Project Overview

The **Expense Tracker Backend** is a production-ready RESTful application built using **Spring Boot** that allows users to record, retrieve, filter, and analyze daily expenses. It follows clean architecture principles, uses DTO-based data transfer, supports pagination and filtering, includes global exception handling, API documentation via Swagger, and basic security.

This project is designed to be **industry-grade**, deployable on cloud platforms (AWS), and suitable for real-world financial tracking use cases.

---

## 🧠 Why This Project Matters

* Demonstrates **clean backend architecture** (Controller → Service → Repository)
* Uses **DTOs** for security and flexibility
* Handles **real-world concerns**: pagination, filtering, validation, exceptions
* Fully testable via **Swagger UI**
* Ready for **AWS deployment**

---

## 🏗️ Architecture (Deep Dive)

### High-Level Flow

```
Client (Swagger / Postman / Frontend)
        ↓
REST Controller (@RestController)
        ↓
Request DTO (@Valid)
        ↓
Service Layer (Business Logic)
        ↓
Repository Layer (JPA)
        ↓
Hibernate ORM
        ↓
PostgreSQL Database
        ↑
Response DTO
```

### Layer-wise Explanation

#### 1️⃣ Controller Layer

* Entry point for HTTP requests
* Handles request mapping (`@GetMapping`, `@PostMapping`)
* Accepts input via **Request DTOs**
* Returns output via **Response DTOs**
* No business logic (keeps controllers thin)

#### 2️⃣ DTO Layer (Security Firewall)

* **Request DTO**: Controls what data client can send
* **Response DTO**: Controls what data client can see
* Prevents direct exposure of database entities
* Enables validation (`@NotBlank`, `@Positive`, etc.)

#### 3️⃣ Service Layer (Business Logic)

* Core of the application
* Handles:

  * Expense creation
  * Pagination & filtering
  * Data transformation (Entity ↔ DTO)
* Keeps logic reusable and testable

#### 4️⃣ Repository Layer

* Interface extending `JpaRepository`
* No SQL written manually
* Hibernate auto-generates queries
* Supports pagination and dynamic queries

#### 5️⃣ Hibernate + JPA

* **Hibernate**: ORM implementation
* **JPA**: Specification (rules)
* Automatically maps Java objects to DB tables
* Handles CRUD, transactions, query execution

---

## ⚙️ Tech Stack

| Layer      | Technology                   |
| ---------- | ---------------------------- |
| Language   | Java 17                      |
| Framework  | Spring Boot 3.x              |
| Web        | Spring Web (REST APIs)       |
| ORM        | Hibernate + JPA              |
| Database   | PostgreSQL                   |
| Validation | Bean Validation (Jakarta)    |
| Security   | Spring Security (Basic Auth) |
| Docs       | Swagger (Springdoc OpenAPI)  |
| Build Tool | Maven                        |
| IDE        | IntelliJ IDEA                |

---

## 🔐 Security

* HTTP Basic Authentication
* Username & password configured via `application.properties`
* All APIs protected
* Swagger supports authorization

---

## 📑 Features Implemented

### ✅ CRUD Operations

* Create Expense (POST)
* Get Expenses (GET)

### ✅ Pagination

* Uses `Pageable` & `Page<T>`
* Efficient for large datasets

### ✅ Filters

* Category filter
* Amount range filter (min / max)
* Date filter (`createdAt`)

### ✅ Validation

* Input validation using annotations
* Clean error messages returned

### ✅ Global Exception Handling

* Centralized error handling using `@ControllerAdvice`
* Consistent error response structure

### ✅ Swagger UI

* Interactive API testing
* No frontend required

---

## 🔎 API Examples

### Create Expense (POST)

```json
{
  "title": "Lunch",
  "amount": 250,
  "category": "FOOD"
}
```

### Get Expenses (GET)

```
/api/expenses?page=0&size=5
```

### Filter Example

```
/api/expenses?category=FOOD&minAmount=100&maxAmount=500
```

---

## ▶️ How to Run Locally

1. Clone the repository

```bash
git clone https://github.com/nivedita1445/Expense-Tracker-Backend-Project.git
```

2. Configure PostgreSQL DB

* Create DB: `expense_tracker_db`
* Update credentials in `application.properties`

3. Run the application

```bash
mvn spring-boot:run
```

4. Open Swagger

```
http://localhost:8080/swagger-ui.html
```

---

## ☁️ Deployment (Planned)

* AWS EC2 (Free Tier)
* PostgreSQL (RDS / EC2)
* Public Swagger URL

---

## 👩‍💻 Author

**Nivedita Wani**
Backend Developer | Java | Spring Boot | AWS

---


This project reflects **real backend engineering practices** used in production systems.
