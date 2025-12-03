-- Active: 1764591940568@@127.0.0.1@3306@libdb
CREATE DATABASE libdb;
USE libdb;

CREATE TABLE books(
    bookId VARCHAR(50) PRIMARY KEY NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    availableCopies INT NOT NULL
);

CREATE TABLE members(
    memberId VARCHAR(50) PRIMARY KEY NOT NULL,
    mname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE record(
    recId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    memberId VARCHAR(50) NOT NULL,
    bookId VARCHAR(50) NOT NULL,
    borrowDate DATE,
    returnDate DATE,
    FOREIGN KEY(memberId) references members(memberId),
    FOREIGN KEY(bookId) references books(bookId)
);

