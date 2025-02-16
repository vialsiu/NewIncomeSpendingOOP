CREATE DATABASE IF NOT EXISTS finance_dept.sql;
use finance_dept.sql;

DROP TABLE IF EXISTS expense;
DROP TABLE IF EXISTS income;

CREATE TABLE expenses (
    expenseID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    amount DOUBLE NOT NULL,
    dateIncurred DATE NOT NULL
);

CREATE TABLE incomes (
    incomeID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    source VARCHAR(50),
    amount DOUBLE NOT NULL,
    dateReceived DATE NOT NULL
);

INSERT INTO expenses (title, category, amount, dateIncurred) VALUES
    ("Power Bill", "Utilities", 85.30, "2025-01-10"),
    ("Book Collection", "Entertainment", 12.99, "2025-01-15"),
    ("Public Transport Pass", "Transport", 50.00, "2025-01-20"),
    ("Car Insurance", "Insurance", 120.75, "2025-02-01"),
    ("Dinner Out", "Dining", 45.20, "2025-02-05"),
    ("Laundry Detergent", "Household Supplies", 9.50, "2025-02-08");

INSERT INTO incomes (title, source, amount, dateReceived) VALUES
    ("Art Commissions", "Side Job", 200.00, "2025-01-06"),
    ("Standard Paycheck", "Salary", 1500.00, "2025-01-15"),
    ("Cashback Reward", "Bank Bonus", 25.00, "2025-01-20"),
    ("Housesitting", "Side Job", 75.50, "2025-01-29"),
    ("Tax Refund", "Government", 300.00, "2025-02-03");
