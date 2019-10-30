##  Organisational news Api

### Description
This is an Api that helps retrieve data for an organization news. The Api lets users to add news, the user details and depart,ment details and can be retrieved. The news can be organized by department, as general news or by the people who posted them.

### By
[Odida Brian](https:/github.com/OdidaProtas)

### Features
#### The user is able to
1. Add general and department news
2. Add user and department details
1. Retrieve news by user
1. Retrieve news by department

### BDD
#### Behavior Driven Development




#### Languages used
1. Java
2. Spark
3. J Unit
4. Gson
5. Psql

### Set Up and Installation
##### Requirements
1. Java JVM installed.
2. IntelliJIDE
3. Postman installed
#### Installation
1. Clone this Repository or download the zip file. Type the command below in your terminal.
 `$ git clone https://github.com/OdidaProtas/Organisational_news_portal.git`
 3. Install PSQL and run command `$ psql ` on the terminal.
 3. Create a database called organisational_api and organisational_api_test by using
   `CREATE DATABASE organisational_api` and `CREATE DATABASE organisational_api_test WITH TEMPLATE orgaisational_api`
  Connect to the database `\c organisational_api`
  and create these tables tables
      1. `CREATE TABLE news(id serial PRIMARY KEY, title VARCHAR, newsContent VARCHAR, writtenBy VARCHAR, departmentId int); `
      1. `CREATE TABLE departments_users(id serial PRIMARY KEY, departmentId int, usersId int); `
      1. `CREATE TABLE users(id serial PRIMARY KEY, title VARCHAR, userName VARCHAR, position VARCHAR, userRole VARCHAR, departmentId int);`
   2. Open the application folder in the IDE and `$ gradle run` on the terminal 
 3. Open Postman and enter the url `http://localhost: 4567`
 3. Feel free to mess with the application as you desire

#### support
email: Bryodiiidah@gmail.com

#### License
(C) 2019 MIT licence