CREATE DATABASE IF NOT EXISTS finance_tracker;
USE finance_tracker;

CREATE TABLE expenses (
    expenseID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    amount DOUBLE NOT NULL,
    dateIncurred DATE NOT NULL
);

CREATE TABLE incomes (
    incomeID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    source VARCHAR(255),
    amount DOUBLE NOT NULL,
    dateReceived DATE NOT NULL
);

