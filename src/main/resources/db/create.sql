SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments(
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    description VARCHAR,
    numberOfEmployees int
);

CREATE TABLE IF NOT EXISTS news(
    id int PRIMARY KEY auto_increment,
    title VARCHAR,
    newsContent VARCHAR,
    writtenBy VARCHAR,
    departmentId int,
--    categoryId int
);

CREATE TABLE IF NOT EXISTS departments_users(
        id int PRIMARY KEY auto_increment,
        departmentId int,
        usersId int
);

CREATE TABLE IF NOT EXISTS users(
    id int PRIMARY KEY auto_increment,
    title VARCHAR,
    userName VARCHAR,
    position VARCHAR,
    userRole VARCHAR,
    departmentId int
);