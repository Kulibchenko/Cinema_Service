# Сinema-app

# Description
## Web application for cinema

This web application allows users to buy movie tickets, book movie theater seats, and get information about upcoming movies.

## Application functions for users

* Buying movie tickets through shopping cart
* Getting information about upcoming movies
* View purchased tickets

## Application functions for the administrator
* Creation of a cinema hall
* Making a movie
* Creating movie sessions

## Basic data:

* Movies
* Cinema halls
* tickets
* Warrants
* Users with shopping cart
* Movie sessions

# Project structure
* Java
    * cinema
      * config - packages with spring config
      * controller - package with our controllers
      * dao - DAO classes to save and load our objects from DB
      * dto - Data Transfer Object
      * exception - our custom exception
      * lib - contain our custom validation annotation
      * model - contain all model
      * security - load our accounts to Spring Security
      * service - package contain our service class
      * util - custom Pattern for Date
    * resources 
      * db.properties - config access to DB


# Used technologies
* Java 17
* Apache Maven 4.0
* Apache TomCat 9.0.74
* Git
* Java Hibernate
* MySql
* Spring WEB MVC
* Spring Security
* Jackson Databind

# DB Schema Structure
![Schema_Cinema.png](ReadMe%2FSchema_Cinema.png)

# Project launch

1. Upload the project from github to Intellij IDEA
2. Configure TomCat
3. Edit next strings in src/main/resources/db.properties to access your database

    db.driver=YOUR_DRIVER

    db.url=YOUR_DATABASE_URL

    db.user=YOUR_LOGIN

    db.password=YOUR_PASSWORD

4. Run the project

