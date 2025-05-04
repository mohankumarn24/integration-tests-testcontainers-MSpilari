# Spring Boot CRUD with Testcontainers

This project demonstrates how to implement a simple CRUD (Create, Read, Update, Delete) application using **Spring Boot** and **Testcontainers** for integration testing. The application manages users stored in a **PostgreSQL** database, and the tests ensure the code runs in a real database environment within Docker containers.

Refer: https://dev.to/mspilari/integration-tests-on-spring-boot-with-postgresql-and-testcontainers-4dpc
## Table of Contents

- [Project Setup](#project-setup)
  - [Prerequisites](#prerequisites)
  - [Running the Application](#running-the-application)
  - [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [License](#license)

---

## Project Setup

### Prerequisites

- **Java 17[21]**: Ensure that you have JDK 17[21] installed.
- **Maven**: The project uses Maven as the build tool.
- **Docker**: Docker is required to run Testcontainers, which manages the PostgreSQL container for testing.

### Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/mohankumarn24/integration_tests_with_testcontainers.git
   ```

2. Navigate to the project directory:

   ```bash
   cd integration_tests_with_testcontainers
   ```

3. Install the dependencies and build the project:

   ```bash
   mvn clean install
   ```

4. Start the application by running:

   ```bash
   mvn spring-boot:run
   ```

5. The application will start on a default port (e.g., `http://localhost:8080`), and you can interact with the API using Postman, Insomnia, or cURL.

---

### Running Tests

To run the integration tests using Testcontainers, execute the following command:

```bash
mvn test
```

The tests will use a PostgreSQL container spun up by Testcontainers, ensuring a clean and isolated database environment for each test.

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.example
│   │       ├── controllers     # REST Controllers for handling HTTP requests
│   │       ├── models          # JPA entities (e.g., UserModel)
│   │       ├── repositories    # Data repositories for database operations
│   │       └── services        # Business logic layer
│   └── resources
│       └── application.properties   # Database configuration
├── test
│   └── java
│       └── com.example
│           └── controllers      # Integration tests using RestAssured & Testcontainers
```

---

## Technologies Used

- **Spring Boot 3.3.4**: For building the backend REST API.
- **Spring Data JPA**: For database interaction and ORM.
- **PostgreSQL**: The relational database used for data persistence.
- **Testcontainers**: For creating a PostgreSQL container to run integration tests in an isolated environment.
- **RestAssured**: For testing REST endpoints in the integration tests.
- **Docker**: To run the database container during testing.
- **Maven**: For building the project and managing dependencies.
- **Swagger**: For the documentation of the project.
- **Redis**: For caching some of the responses of endpoints.

---

## Documentation

Acess the API documentation on http://localhost:8080/swagger-ui.html

---

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

Forked from https://github.com/MSpilari/integration_tests_with_testcontainers

---

---
