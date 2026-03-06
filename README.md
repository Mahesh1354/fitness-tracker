# Fitness Tracker Application (Backend)

A **Spring Boot REST API** for a Fitness Tracker Application that allows users to manage workout activities and track fitness records.  
The backend provides APIs for creating, updating, retrieving, and deleting fitness activities, with data stored in a **MySQL database** using **Spring Data JPA and Hibernate**.

---

## Tech Stack

**Backend**
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- REST APIs

**Database**
- MySQL

**Tools**
- Maven
- Postman
- Git
- IntelliJ IDEA

---

## Features

- RESTful APIs for managing fitness activities
- Create, update, delete, and view workout records
- MySQL database integration using **Spring Data JPA**
- Entity relationship mapping using **Hibernate**
- Data validation and exception handling
- Structured backend architecture with **Controller, Service, and Repository layers**

---

## Project Structure

```

fitness-tracker
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── fitness
│   │   │           ├── controller
│   │   │           ├── service
│   │   │           ├── repository
│   │   │           ├── model
│   │   │           └── exception
│   │   │
│   │   └── resources
│   │       ├── application.properties
│   │
├── pom.xml
└── README.md

```

---

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| GET | /api/activities | Get all fitness activities |
| GET | /api/activities/{id} | Get activity by ID |
| POST | /api/activities | Create a new activity |
| PUT | /api/activities/{id} | Update activity |
| DELETE | /api/activities/{id} | Delete activity |

---

## Installation and Setup

### 1 Clone the repository

```

git clone [https://github.com/Mahesh1354/fitness-tracker.git](https://github.com/Mahesh1354/fitness-tracker.git)

```

### 2 Navigate to the project folder

```

cd fitness-tracker

```

### 3 Configure Database

Update `application.properties` with your MySQL configuration.

```

spring.datasource.url=jdbc:mysql://localhost:3306/fitness_tracker
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

```

### 4 Run the Spring Boot application

```

mvn spring-boot:run

```

Server will start at:

```

[http://localhost:8080](http://localhost:8080)

```

---

## Testing APIs

You can test the APIs using:

- Postman
- cURL
- Thunder Client (VS Code)

---

## Future Improvements

- Add **Spring Security with JWT authentication**
- Implement **user accounts and login**
- Add **activity analytics and reports**
- Integrate with **frontend (React / Angular)**

---

## Author

**Mahesh Swami**

GitHub  
https://github.com/Mahesh1354

LinkedIn  
https://linkedin.com/in/mahesh-swami-3b4950268
