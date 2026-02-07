# 🏦 Banking Management System
This repository contains the code for a Spring Boot-based Banking Management System designed to handle core banking operations such as customer management, account handling, role-based access control, transaction processing, loan management, and security features like balance encryption.

## Overview
We propose a secure and modular Banking Management System built using Spring Boot with layered architecture and role-based access control for different users (Admin, Manager, Teller, Auditor, etc.). This system ensures data confidentiality, secure transactions, and scalability. The system architecture is designed to encrypt sensitive data like account balances, while allowing automatic decryption during read operations.

## 🔑 Key Features
- 🧾 Customer & Account Management
- 🔐 Encrypted Account Balance
- 👥 Role-based Access Control (Admin, Manager, Teller, etc.)
- 💸 Deposit/Withdraw/Transfer
- 📋 Loan Request & Approval Workflow
- 📊 Transaction History & Audit Logs
- 🧠 Scheduled Auto EMI Payments

## Requirements
🧰 Environments & Dependencies
The project requires the following:

- Java 17
- Spring Boot 3.1+
- Gradle Build Tool
- PostgreSQL (for persistence layer)
- Lombok (for cleaner code)
- Spring Security (for role-based authentication & authorization)
- JPA/Hibernate (ORM and DB handling)

## ⚙️ How to Run
To run the Banking Management System, follow these steps:

## ✅ Prerequisites
- Java 17+
- PostgreSQL installed and running
- Gradle installed (or use the Gradle Wrapper included)
- IDE (e.g., IntelliJ IDEA, Eclipse)


## 🔧 Setup Instructions
### 1. Clone the repository:
```
    bash
   
    git clone https://github.com/KirtanBhavsar2193/Banking-Management-System.git
    cd Banking-Management-System
```

### 2. Configure PostgreSQL:

- Create a database named banking_db
- Update your DB credentials in application.properties:
```
    properties

    spring.datasource.url=jdbc:postgresql://localhost:5432/banking_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    Build and run the application:
```
### 3. Build and run the application:
```
    bash
    ./gradlew bootRun
```

### 4. Access the application:

- Swagger UI: http://localhost:8080/swagger-ui/index.html
- APIs start from: http://localhost:8080/api/...

## 📂 Project Structure
```
    Banking-Management-System/
    ├── controller/              # REST controllers for different modules
    │   ├── AccountController.java
    │   ├── UserController.java
    │   ├── LoanController.java
    │   └── RoleController.java
    │
    ├── model/                   # DTOs and helper models
    │   ├── entity/                  # JPA entity classes
    │   │   ├── User.java
    │   │   ├── Role.java
    │   │   ├── UserRole.java
    │   │   ├── Permission.java
    │   │   ├── RolePermission.java
    │   │   ├── Passbook.java
    │   │   ├── Account.java
    │   │   └── Loan.java
    │   ├── error/
    │   │   ├── ErrorResponse.java
    │   │   └── ErrorType.java
    │   ├── AccountModel.java
    │   ├── EmiPaidCountModel.java
    │   ├── LoanCalculateModel.java
    │   ├── LoanInfoModel.java
    │   ├── MessageModel.java
    │   ├── PassbookModel.java
    │   ├── RoleModel.java
    │   ├── TransactionModel.java
    │   ├── TransferInfoModel.java
    │   ├── TransferMessageModel.java
    │   ├── UserAccountModel.java
    │   ├── UserDitailModel.java
    │   ├── UserDitails.java
    │   ├── UserLoanModel.java
    │   ├── UserModel.java
    │   └── UserPassbookModel.java
    │
    ├── service/                 # Business logic
    │   ├── AccountService.java
    │   ├── AuthService.java
    │   ├── JWTService.java
    │   ├── LoanService.java
    │   ├── RoleService.java
    │   ├── UserDitailsService.java
    │   └── UserService.java
    │
    ├── repository/              # Spring Data JPA repositories
    │   ├── AccountRepository.java
    │   ├── LoanRepository.java
    │   ├── PassbookRepository.java
    │   ├── RoleRepository.java
    │   ├── UserRepository.java
    │   └── UserRoleRepository.java
    │
    ├── config/                # JWT + Role-based security config
    │   └── SecurityConfig.java
    │
    ├── filter/               # filter-related classes
    │   └──JWTFilter.java
    │
    ├── util/   # Utility classes (e.g., encryption)
    │   ├── EncryptionUtil.java
    │   └── BalanceEncryptDecryptConverter.java
    │
    ├── exception/               # Custom exception handling
    │   ├── handlers/            # Exception handlers
    │   │   └── GlobalExceptionHandler.java
    │   ├── DataNotFoundException.java 
    │   ├── DataValidationException.java
    │   └── EncryptDecryptException.java
    │
    ├── enumerations/
    │   ├── LoanStatus.java
    │   ├── LoanType.java
    │   ├── PermissionEnum.java
    │   └── Status.java    
    │
    ├── mapper/
    │   ├── AccountMapper.java
    │   ├── LoanMapper.java
    │   ├── PassbookMapper.java
    │   ├── RoleMapper.java
    │   └── UserMapper.java
    │
    ├── Application.java         # Main Spring Boot application
    └── application.yml   # App config (DB, port, etc.)
```

## 📌 Usage Example

### 🧾 Register a New User (POST /api/users/register)
```
json
    
    {
        "name": "John Doe",
        "email": "john@example.com",
        "password": "securePass123",
        "role": "CUSTOMER"
    }
```

### 🔐 Login to Get JWT Token (POST /api/users/login)
```
json
    
    {
        "email": "john@example.com",
        "password": "securePass123"
    }
```

#### Response:
```
json
    
    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI..."
    }
```

##### Use this token in headers:
```
makefile

    Authorization:  <token>
```

### 💰 Create Account (POST /api/accounts/create)
```
json

    {
      "userId": "123e4567-e89b-12d3-a456-426614174000",
      "accountType": "SAVINGS",
      "initialBalance": 5000
    }
```
