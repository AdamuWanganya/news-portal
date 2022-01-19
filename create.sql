CREATE DATABASE portal_news;

\c portal_news

CREATE TABLE departments (id SERIAL PRIMARY KEY, name varchar, description varchar);

CREATE TABLE users (id SERIAL PRIMARY KEY, name varchar, position varchar, yearsActive int, departmentId int);

CREATE TABLE news (id SERIAL PRIMARY KEY, name varchar, content varchar, departmentId int);

CREATE TABLE departments_news (id SERIAL PRIMARY KEY, departmentId int, newsId int);

CREATE TABLE departments_users (id SERIAL PRIMARY KEY, departmentId int, userId int);

CREATE DATABASE portal_news_test WITH TEMPLATE portal_news;