# Spring Boot CRUD with Testcontainers

This project demonstrates how to implement a simple CRUD (Create, Read, Update, Delete) application using **Spring Boot** and **Testcontainers** for integration testing. The application manages users stored in a **PostgreSQL** database, and the tests ensure the code runs in a real database environment within Docker containers.

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
   git clone https://github.com/MSpilari/integration_tests_with_testcontainers.git
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

---

---

# Spring Boot CRUD com Testcontainers

Este projeto demonstra como implementar uma aplicação simples de CRUD (Criar, Ler, Atualizar, Deletar) usando **Spring Boot** e **Testcontainers** para testes de integração. A aplicação gerencia usuários armazenados em um banco de dados **PostgreSQL**, e os testes garantem que o código seja executado em um ambiente real de banco de dados dentro de containers Docker.

## Índice

- [Configuração do Projeto](#configuração-do-projeto)
  - [Pré-requisitos](#pré-requisitos)
  - [Executando a Aplicação](#executando-a-aplicação)
  - [Executando Testes](#executando-testes)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Licença](#licença)

---

## Configuração do Projeto

### Pré-requisitos

- **Java 21**: Certifique-se de ter o JDK 21 instalado.
- **Maven**: O projeto usa o Maven como ferramenta de build.
- **Docker**: O Docker é necessário para executar o Testcontainers, que gerencia o container PostgreSQL para testes.

### Executando a Aplicação

1. Clone o repositório:

   ```bash
   git clone https://github.com/mohankumarn24/integration_tests_with_testcontainers.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd integration_tests_with_testcontainers
   ```

3. Instale as dependências e compile o projeto:

   ```bash
   mvn clean install
   ```

4. Inicie a aplicação executando:

   ```bash
   mvn spring-boot:run
   ```

5. A aplicação será iniciada em uma porta padrão (por exemplo, `http://localhost:8080`), e você pode interagir com a API usando Postman, Insomnia ou cURL.

---

### Executando Testes

Para rodar os testes de integração utilizando Testcontainers, execute o seguinte comando:

```bash
mvn test
```

Os testes usarão um container PostgreSQL gerenciado pelo Testcontainers, garantindo um ambiente de banco de dados limpo e isolado para cada execução de teste.

---

## Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── com.example
│   │       ├── controllers     # Controladores REST para lidar com requisições HTTP
│   │       ├── models          # Entidades JPA (ex: UserModel)
│   │       ├── repositories    # Repositórios de dados para operações com o banco
│   │       └── services        # Camada de lógica de negócios
│   └── resources
│       └── application.properties   # Configuração do banco de dados
├── test
│   └── java
│       └── com.example
│           └── controllers      # Testes de integração com RestAssured & Testcontainers
```

---

## Tecnologias Utilizadas

- **Spring Boot 3.3.4**: Para construção da API REST do backend.
- **Spring Data JPA**: Para interação com o banco de dados e ORM.
- **PostgreSQL**: O banco de dados relacional utilizado para persistência de dados.
- **Testcontainers**: Para criar um container PostgreSQL e executar os testes de integração em um ambiente isolado.
- **RestAssured**: Para testar os endpoints REST nos testes de integração.
- **Docker**: Para rodar o container do banco de dados durante os testes.
- **Maven**: Para build do projeto e gerenciamento de dependências.
- **Swagger**: Para a documentação do projeto.
- **Redis**: Armazenamento de cache.

---

## Documentação

Acesse a documentação da API em http://localhost:8080/swagger-ui.html

---

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).

---
