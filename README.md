# Project Setup

### Requirements

* Java 17
* Gradle
* Lombok
* MySql database

### Database initialization (queries)

* create database demo;
* create table book(id INT NOT NULL AUTO_INCREMENT, title NOT NULL VARCHAR(50), author NOT NULL VARCHAR(30), publishedDate DATE, PRIMARY KEY (id));
* create index idx_author ON book(author);
* create index idx_title ON book(title);

### Gradle Commands

* ./gradlew clean build
* ./gradlew bootRun
* ./gradlew integrationTest
* ./gradlew test

