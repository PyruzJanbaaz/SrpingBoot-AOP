# SpringBoot Rest API - AOP
A sample project by spring boot and AOP for logging any request/responses by calling Rest APIs

I create a Spring Boot project for logging any requests and responses by calling Rest APIs. You need the following tools and technologies to develop the same.
- Spring-Boot 2.1.3.RELEASE
- Spring-aop 5.1.5.RELEASE
- Lombok 1.18.6
- JavaSE 1.8
- Maven 3.3.9

# Dependencies
Open the pom.xml file for spring-aop configuration:

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
        </dependency>

# Features

- Automatically logs input and output
- Automatically logs errors occurring in API
- No side-effect in actual API implementation due to AOP logic
- Automatically sync to new APIs
- Works with unit testing
- Config logback setting like file paht, file rolling and archive path, file size, ...


# Usage

Make a new request by postman: [POST] http://localhost:8080/api/user:

        "firstName":"Pyruz",
        "lastName":"Janbaaz",
        "phoneNumber": 5860054991,
        "isActive": true
    
Then go to your configured loggin path and open the log file, You should find lines similar to the following in the log file:

- {user=User(firstName=Pyruz, lastName=Janbaaz, phoneNumber=5860054991, isActive=true)}
- ResultDTO(code=0, message=User created successfully!)
  
