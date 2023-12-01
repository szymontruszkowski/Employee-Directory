# Employee-Directory

This **MVC** application lets you to manage employee directory by adding new employees and updating/deleting current ones. <br>

Front-end layer of app has been built using **HTML** and finished with simple **Bootstrap** styling. <br>

The app uses embedded **H2 database** for saving employees. <br>

**Spring Security** has been implemented to enable login and restric URLs based on user role(s). <br>

Few predefined **Employee** entities are loaded into database on startup in **DataLoader** class. <br>

## Technologies used in the project

- Java
- MVC
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Boot Dev Tools
- Spring Security
- H2 Database
- Thymeleaf
- HTML
- CSS
- Bootstrap

## Spring Security

**Spring Security** has been configured in **SecurityConfig** class. <br>
Three example **users** with different **role(s)** have been definied. <br>

| Username | Password | Role(s) |
|--|--|--|
| lucas | lucas123 | EMPLOYEE |
| william| william123 | EMPLOYEE, MANAGER |
| emma| emma123| EMPLOYEE, MANAGER, ADMIN |

App functionalities are restricted based on user role(s).

| Role | Action(s) |
|--|--|
| EMPLOYEE | reviewing, sorting |
| MANAGER | adding, updating |
| ADMIN | deleting | 

## How to access H2 Database

To access database go to **localhost:8080/h2-console**.
- JDBC URL - **jdbc:h2:mem:testdb**
- Username - **admin**
- Password - **admin**

## How to run this application

To run the app:
- clone this repo to your local drive
- open it in IDE
- run **main()** method in **EmployeeDirectoryApplication** class
- in your web browser go to **localhost:8080**
- use login credentials described in **Spring Security** section