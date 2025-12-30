# Trust API
A Spring Boot based Micro Lending Platform named Trust API that allows borrowers to request loans, lenders to fund them, and admins to approve/reject loans.
The application includes JWT-based authentication, Swagger API documentation, with JPA, MySQL, and Docker support.

# Features:
1. Loan Management
2. Lender Module
3. Security and Authentication
4. API Documentation using Swagger UI
5. Docker support

# Built using:

 Layer      | Technology                  
 ---------- | --------------------------- 
 Language   | Java 17                     
 Framework  | Spring Boot 3.x           
 Security   | Spring Security and JWT       
 ORM        | Spring Data JPA             
 Database   | MySQL                     
 API Docs   | Springdoc OpenAPI (Swagger) 
 Build Tool | Maven                       
 Container  | Docker     

 # How to Run the application locally:

 a. Clone the repo:

 git clone https://github.com/Shipra8/Trust-API.git

 cd Trust-API
 
 b. Docker Setup: App engine needs to run, 

 In Command Prompt,
 
 docker --version
 
 docker ps

 docker run -d \
  --name mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=microlending \
  -p 3306:3306 \
  mysql:8
Check the username and password from application.properties

 c. Application Run
 
 1. mvn clean install
 2. mvn spring-boot:run
Once the Tomcat server starts,

d. Swagger- API Documentation

http://localhost:8080/swagger-ui.html


# API Screenshots

![Trust API](https://github.com/user-attachments/assets/00b9f248-e364-4c6e-83ae-0e8e4fc4fb5b)                 ![Trust API SQL](https://github.com/user-attachments/assets/36de3a79-a298-4481-9c5f-1116d733665c)  

![Trust API 2](https://github.com/user-attachments/assets/f5be51c4-ad6e-4cf7-b7ab-9e717e43ca38)


![Trust API 1](https://github.com/user-attachments/assets/14ff88dd-9c30-45e1-abd5-0ec3a3021035)                   ![Trust API 3](https://github.com/user-attachments/assets/06a5126b-7e1c-4e95-9c69-e66203d60cf0)

![Trust API 4](https://github.com/user-attachments/assets/db534795-2727-42c8-a0c5-e4b18dcb5ff1)  



