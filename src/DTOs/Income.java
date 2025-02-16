package DTOs;

import java.sql.Date;

public class Income {
    private int incomeID;
    private String title;
    private String source;
    private double amount;
    private Date dateReceived;

    public Income(int incomeID, String title, String source, double amount, Date dateReceived) {
        this.incomeID = incomeID;
        this.title = title;
        this.source = source;
        this.amount = amount;
        this.dateReceived = dateReceived;
    }

    // ----- my constructor for inserts
    public Income(String title, String source, double amount, Date dateReceived) {
        this(0, title, source, amount, dateReceived);
    }

    public int getIncomeID() { return incomeID; }
    public String getTitle() { return title; }
    public String getSource() { return source; }
    public double getAmount() { return amount; }
    public Date getDateReceived() { return dateReceived; }

    @Override
    public String toString() {
        return String.format("Income [ID: %d, Title: %s, Category: %s, Amount: %.2f, Date: %s]",
                incomeID, title, source, amount, dateReceived);
    }
}