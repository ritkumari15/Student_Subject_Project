# Student_Subject_Project
### Requirements
- **Java 21**
- **Maven 3.6+**
- **Spring Boot 3.1+**
  
### Overview of project
   This Spring Boot application is a student management system with entities `Student` and `Subject`, featuring a many-to-many relationship. It offers RESTful API endpoints for managing students and subjects, 
    with data persistence using Spring Data JPA and an H2 database.
### Technologies Used:--
- **Spring Boot: To create a stand-alone, production-grade Spring-based application.**
- **Spring MVC: To handle HTTP requests and serve RESTful endpoints.**
- **Spring Data JPA: To interact with the database using Java Persistence API (JPA).**
- **H2 Database: An in-memory database for testing and development purposes.**
- **Maven: For managing project dependencies and build lifecycle**
 
 ### Repository Structure
     src/main/java/com/Test/controller/: Contains REST controllers for handling HTTP requests for students and subjects.
     src/main/java/com/Test/service/: Contains service classes for business logic and data manipulation.
     src/main/java/com/Test/entity/: Contains JPA entity classes for students and subjects.
     src/main/java/com/Test/repository/: Contains JPA repositories for database operations.
 #### main/java
     └── com.Test
        ├── SpringTechApplication.java
        ├── controller/
        │   ├── StudentController.java
        │   └── SubjectController.java
        ├── entity/
        │   ├── Student.java
        │   └── Subject.java
        ├── repository/
        │   ├── StudentRepository.java
        │   └── SubjectRepository.java
        └── service/
            ├── StudentService.java
            └── SubjectService.java

### application.properties
spring.application.name=Spring_tech
#### Data source:
##### spring.datasource.url=jdbc:h2:file:C:/Users/Lenovo/test
##### spring.datasource.driver-class-name=org.h2.Driver
##### spring.datasource.username=sa
##### spring.datasource.password=
##### spring.jpa.generate-ddl=true
##### server.port=9090
#### Jpa/Hibernate:
##### spring.jpa.hibernate.ddl-auto=none
##### spring.h2.console.enabled=true #####spring.h2.console.path=/h2-console
#### spring.jpa.show-sql=true
##### spring.jpa.open-in-view=true
#### Hibernate Properties
#### Hibernate ddl auto (create, create-drop, validate, update)
##### spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.H2Dialect
#### Enable H2 Console-http://localhost:9090/h2-console
##### logging.level.org.springframework=DEBUG


#### REST API Endpoints of Student:

  ##### POST /students: Create a new student.
  ##### GET /students: Retrieve a list of all students.
  ##### POST /students: Create a new student.
  ##### GET /sutudents: Retrieve a list of all students.

#### REST API Endpoints of Student:

##### POST /students: Create a new subject.
##### GET /students: Retrieve a list of all subject.
##### POST /subjects: Create a new subject.
##### GET /subjects: Retrieve a list of all subjects.

### Subjects
Create Student: POST /api/subjects
curl --location 'http://localhost:9090/api/subjects' \
--header 'Content-Type: application/json' \
--data '
    
    {
        
        "name": "English"
    }'
Request Body: { "name": "English"}
Response: Student object with 201 Created
{
    "id": 2,
    "name": "English"
}
#### Get All Subjects: GET /api/subjects
curl --location --request GET 'http://localhost:9090/api/subjects' \
--header 'Content-Type: application/json' \
--data '
    
    {
        
        "name": "Hindi"
    }'
[
    {
        "id": 1,
        "name": "Science"
    },
    {
        "id": 2,
        "name": "English"
    },
    {
        "id": 3,
        "name": "Hindi"
    }
]
**Response: List of Subject objects with 200 OK
#### Get Subject by ID: GET /api/subjects/{id}
curl --location --request GET 'http://localhost:9090/api/subjects/3' \
--header 'Content-Type: application/json' \
--data '
    
    {
        
        "name": "Hindi"
    }'
{
    "id": 3,
    "name": "Hindi"
}

** Response: Subject object if found, otherwise 404 Not Found
#### Update Subject: PUT /api/subjects/{id}
curl --location --request PUT 'http://localhost:9090/api/subjects/4' \
--header 'Content-Type: application/json' \
--data '
    
    {
        
        "name": "physics"
    }'
{
    "id": 4,
    "name": "physics"
}
** Request Body: { "name": "physics" }
** Response: Updated Subject object with 200 OK
#### Delete Subject: DELETE /api/subjects/{id}

Response: 204 No Content upon successful deletion

### Students
#### Create Student: POST /api/students
curl --location 'http://localhost:9090/api/students' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "ram",
    "address": "delhi",
    "email": "harry@example.com"
     
}'
Request Body: { "name": "ram", "address": "delhi", "email": "harry@example.com" }
Response: Student object with 201 Created
{
    "id": 1,
    "name": "ram",
    "address": "delhi",
    "email": "harry@example.com",
    "subjects": []
}
#### Get Student by ID: GET /api/students/{id}
curl --location --request GET 'http://localhost:9090/api/students/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "sam",
    "address": "jaipur",
    "email": "sam@example.com"
     
}'
** Response: Student object if found, otherwise 404 Not Found
{
    "id": 3,
    "name": "sam",
    "address": "jaipur",
    "email": "sam@example.com",
    "subjects": []
}
##### Get All Students: GET /api/students
curl --location --request GET 'http://localhost:9090/api/students' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "sam",
    "address": "jaipur",
    "email": "sam@example.com"
     
}'
[
    {
        "id": 1,
        "name": "ram",
        "address": "delhi",
        "email": "harry@example.com",
        "subjects": []
    },
    {
        "id": 2,
        "name": "doly",
        "address": "goa",
        "email": "doly@example.com",
        "subjects": []
    },
    {
        "id": 3,
        "name": "sam",
        "address": "jaipur",
        "email": "sam@example.com",
        "subjects": []
    }
]
** Response: List of Student objects with 200 OK

#### Update Student: PUT /api/students/{id}
curl --location --request PUT 'http://localhost:9090/api/students/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "aani",
    "address": "jaipur",
    "email": "sam@example.com"
     
}'
Request Body: { "name": "aani ", "address": "jaipur", "email": "sam@example.com" }
Response: Updated Student object with 200 OK
{
    "id": 3,
    "name": "aani",
    "address": "jaipur",
    "email": "sam@example.com",
    "subjects": []
}
#### Delete Student: DELETE /api/students/{id}
curl --location --request DELETE 'http://localhost:9090/api/students/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "sam",
    "address": "jaipur",
    "email": "sam@example.com"     
}'
** Response: 200 OK upon successful deletion
#### Assign Subject to Student: PUT /api/students/{studentId}/subjects/{subjectId}
curl --location --request PUT 'http://localhost:9090/api/students/1/subjects/2'
{
    "id": 1,
    "name": "ram",
    "address": "delhi",
    "email": "harry@example.com",
    "subjects": [
        {
            "id": 2,
            "name": "English"
        }
    ]
}
** Response: Updated Student object with assigned subject

#### To running your Spring Boot project:
#### Install Prerequisites
Java 21: Install it from Oracle or AdoptOpenJDK.
#### Clone the Project
Open your terminal and run:
git clone <repository-url>
#### Navigate to the Project Directory
##### Change into the directory of the cloned repository:
cd <repository-directory>
#### Import the Project into Your IDE
#### Run the Application
-**Right-click on SpringTechApplication.java and select Run As > Spring Boot App.**
#### Access the Application
Open your web browser and go to:
-**H2 Console: http://localhost:9090/h2-console**
-**API Endpoints:http://localhost:9090/api/students etc**
#### Stop the Application
Click the red stop button in the Console view.






