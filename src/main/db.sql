-- Active: 1764591940568@@127.0.0.1@3306@librarydb
CREATE DATABASE librarydb;
USE librarydb;

CREATE TABLE books(
    bookid INT PRIMARY KEY NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    availableCopies INT NOT NULL
);

