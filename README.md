
# KredinBizde - SpringBoot

This project is an example application that allows users to make credit and credit card applications offered by various banks over the internet. This application has basic functionalities such as user registration, credit application submission, user inquiry via email address, and inquiry of user applications.

## Used Technologies

    Spring Boot
    RabbitMQ
    Apache Kafka
    Redis
    MySQL
    MongoDB
    JUnit
    Mockito
## Web Helpers End Points



 ### Service Discovery
 `localhost:8761/`
 
 ### RabbitMQ Web Tool
 `localhost:15672/`
 
 ### Kafka UI
 `localhost:9090/`



  
## Docker Containers

**MySQL** : 
+ `docker pull mysql`
+ `docker run -e MYSQL_ROOT_PASSWORD=password  -p 3307:3306 mysql`

**RabbitMQ**
  + `docker pull rabbitmq` 
  + `docker run -d --hostname rabbit --name rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management`

**KredinBizde-Servis ve LogServis have their docker-compose files.** 

  
