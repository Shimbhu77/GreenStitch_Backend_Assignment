# GreenStitch Backend Assignment
# Login and Signup Backend API with Spring Security and JWT Tokens

This project is a backend implementation of a login and signup REST API with security and JWT tokens. It is built using Java, and Spring Boot, and utilizes the H2 database for data storage. The API endpoints provided below demonstrate the functionality of the application.

## Installation and Setup

```
### Prerequisites
- Java Development Kit (JDK) 8 or later
- Maven
- Postman (for testing the API)
```

### 1. Clone the Repository

```
git clone https://github.com/Shimbhu77/GreenStitch_Backend_Assignment.git
```

### 2. Go the Project

```
cd GreenStitch_Backend_Assignment/GreenStitch_Assignment

```

### 3. Run the Application
- For GitBash
```
./mvnw spring-boot:run

```
**The application will start running on [http://localhost:8888](http://localhost:8888)**

### **API Endpoints**

### User Signup

- Method: POST
- Path: `http://localhost:8888/app/sign-up`
- Description: Register a new user.
- Request Body: User data in the JSON format (e.g., name, email, password).

```

{
  "fullName": "Shimbhu Kumawat",
  "password": "Shimbhu@123",
  "email": "sk@gmail.com"
}
```

- Response:

```
{
    "id": 1,
    "fullName": "Shimbhu Kumawat",
    "password": "$2a$10$KVzpEHKFpX2ephA7RXLgqumnZKFy3bT8wdJMW3tYH2yqUJcpZPGSG",
    "email": "sk@gmail.com",
    "role": "ROLE_USER"
}

```

### User Login

- Method: GET
- Path: `http://localhost:8888/app/sign-in`
- Description: Authenticate a user and retrieve their details and JWT token.
- Authentication: Basic Authentication (Username and Password)
    - Username: [sk@gmail.com](mailto:sk@gmail.com)
    - Password: Shimbhu@123
- Response:

```
{
    "id": 1,
    "fullName": "Shimbhu Kumawat",
    "password": "$2a$10$KVzpEHKFpX2ephA7RXLgqumnZKFy3bT8wdJMW3tYH2yqUJcpZPGSG",
    "email": "sk@gmail.com",
    "role": "ROLE_USER"
}

```

### Welcome Endpoint (Requires Authentication)

- Method: GET
- Path: `http://localhost:8888/app/logged-in/user`
- Description: A protected endpoint that requires authentication to access.
- Authentication: Bearer Token
- Request Header:
    - Authorization: Bearer <token>
- Response: A welcome message string.
- Example:
    - Bearer Token: eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJTaGltYmh1Iiwic3ViIjoiSldUIFRva2VuIiwidXNlcm5hbWUiOiJza0BnbWFpbC5jb20iLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNjg1Njc3Mzg3LCJleHAiOjE2ODU3MDczODd9.VwM2IGD1fABjEcnNoMb4uIyBnYe3_BmZGx33dElaD-E
    - Response: Hello from GreenStitch

### Tech Stack

- Java
- Spring Boot
- H2 Database
- Spring Security
- JWT Token
- Lombok
- Maven
- Swagger-UI

### Validation Rules

The following validation rules are applied to the user entity:

- Full Name:
    - Minimum length: 3 characters
    - Maximum length: 20 characters
- Password:
    - At least 8 characters
    - Contains at least one digit
    - Contains at least one lowercase letter
    - Contains at least one uppercase letter
    - Contains at least one special character
- Email:
    - Valid email format

### Development

The project can be imported and run using an IDE like Eclipse.

### Test API

You can use Postman and Swagger-UI to test the API endpoints.

## H2 Database Configuration

The project uses the H2 in-memory database by default.

The application is configured to use the H2 database. The configuration can be found in the `application.properties` file:

```
# Server Port Configuration
server.port=8888

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

```

## **Contributors**

- **[Shimbhu Kumawat](https://github.com/Shimbhu77)**
 
