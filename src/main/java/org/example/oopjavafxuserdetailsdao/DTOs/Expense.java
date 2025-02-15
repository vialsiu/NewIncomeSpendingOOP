package org.example.oopjavafxuserdetailsdao.DTOs;

import java.sql.Date;
import java.util.List;


public class Expense {
    private int expenseId;
    private String title, category;
    private double amount;
    private Date dateIncurred;

    public Expense(int expenseId, String title, String category, double amount, Date dateIncurred) {
        this.expenseId = expenseId;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

//    public Expense(String title, String category, double amount, Date dateIncurred) {
//        this(0, title, category, amount, dateIncurred);
//    }

    public Expense(String title, String category, double amount,  Date dateIncurred) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }


    public int getExpenseId()
    {
        return expenseId;
    }
    public void setExpenseId(int expenseId)
    {
        this.expenseId = expenseId;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getCategory()
    {
        return category;
    }
    public void setCategory(String category)
    { this.category = category;
    }
    public double getAmount()
    {
        return amount;
    }
    public void setAmount(double amount)
    {
        this.amount = amount;
    }
    public Date getDateIncurred()
    {
        return dateIncurred;
    }
    public void setDateIncurred(Date dateIncurred)
    {
        this.dateIncurred = dateIncurred;
    }

    public double calculateTotalSpend(List<Expense> expenseList) {
        double totalValue = 0;
        for (Expense expense : expenseList) {
            totalValue += expense.getAmount();
        }
        return totalValue;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", dateIncurred=" + dateIncurred +
                '}';
    }
}