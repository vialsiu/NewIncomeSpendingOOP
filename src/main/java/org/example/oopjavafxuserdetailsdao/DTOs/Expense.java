package org.example.oopjavafxuserdetailsdao.DTOs;

import java.sql.Date;

public class Expense {
    private int expenseID;
    private String title;
    private String category;
    private double amount;
    private Date dateIncurred;

    public Expense(int expenseID, String title, String category, double amount, Date dateIncurred) {
        this.expenseID = expenseID;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    // Constructor without ID (for inserts)
    public Expense(String title, String category, double amount, Date dateIncurred) {
        this(0, title, category, amount, dateIncurred);
    }

    // Getters
    public int getExpenseID() { return expenseID; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public Date getDateIncurred() { return dateIncurred; }

    @Override
    public String toString() {
        return String.format("Expense [ID: %d, Title: %s, Category: %s, Amount: %.2f, Date: %s]",
                expenseID, title, category, amount, dateIncurred);
    }
}