# Employee-Directory

MVC application made using technologies such as Java, Spring Boot and Thymeleaf.</br>
Front-end layer of application was built using HTML and finished with simple Bootstrap styling.</br>
The app lets you to manage employee directory by adding new employees and updating/deleting current ones.</br>
The app uses embedded H2 database for saving employees.</br></br>
Spring Security was implemented to enable login and restrict URLs based on user roles.</br>
3 example users with different roles were defined in SecurityConfig class:</br>
- EMPLOYEE: reviewing/sorting</br>
- MANAGER: adding/updating</br>
- ADMIN: deleting</br>
Check SecurityConfig class for login credentials.</br>
