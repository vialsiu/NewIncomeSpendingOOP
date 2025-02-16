package DTOs;

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

    // ----- my constructor for inserts
    public Expense(String title, String category, double amount, Date dateIncurred) {
        this(0, title, category, amount, dateIncurred);
    }

    public int getExpenseID() { return expenseID; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public Date getDateIncurred() { return dateIncurred; }

    @Override
    public String toString() {
        return "Expense [ID: " + expenseID + ", Title: " + title + ", Category: " + category + ", Amount: " + String.format("%.2f", amount) + ", Date: " + dateIncurred + "]";
    }

}