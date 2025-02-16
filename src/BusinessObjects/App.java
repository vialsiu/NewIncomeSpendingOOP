package BusinessObjects;

import DAOs.IncomeDAO;
import DAOs.ExpenseDAO;
import DTOs.Income;
import DTOs.Expense;
import Exceptions.DaoException;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IncomeDAO incomeDAO = new IncomeDAO();
        ExpenseDAO expenseDAO = new ExpenseDAO();

        boolean finished = false;

        while (!finished) {
            System.out.println("\n\t\s\s\s【\uFEFFFINANCE DEPT】");
            System.out.println("--- Look at your finances. ---");
            System.out.println("1) List all incomes.");
            System.out.println("2) Display all expenses.");
            System.out.println("3) Delete an income by ID number.");
            System.out.println("4) Delete an expense by ID number.");
            System.out.println("5) Add a new income.");
            System.out.println("6) Add a new expense.");
            System.out.println("7) Analyse income and expenses by month.");
            System.out.println("8) Exit.");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // -------- list all incomes
                    try {
                        List<Income> incomes = incomeDAO.findAllIncome();
                        for (Income income : incomes) {
                            System.out.println(income);
                        }
                    } catch (DaoException e) {
                        System.out.println("Error retrieving incomes: " + e.getMessage());
                    }
                    break;

                case "2":
                    // -------- list all expenses
                    try {
                        List<Expense> expenses = expenseDAO.listAllExpenses();
                        for (Expense expense : expenses) {
                            System.out.println(expense);
                        }
                    } catch (DaoException e) {
                        System.out.println("Error retrieving expenses: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;

                case "3":
                    // ------- delete an income by ID
                    System.out.print("Enter the ID of the income to delete: ");
                    int incomeID = Integer.parseInt(scanner.nextLine());
                    try {
                        incomeDAO.deleteIncome(incomeID);
                        System.out.println("Income with ID " + incomeID + " deleted successfully.");
                    } catch (DaoException e) {
                        System.out.println("Error deleting income: " + e.getMessage());
                    }
                    break;

                case "4":
                    // -------- delete an expense by ID
                    System.out.print("Enter the ID of the expense to delete: ");
                    int expenseID = Integer.parseInt(scanner.nextLine());
                    try {
                        expenseDAO.deleteExpense(expenseID);
                        System.out.println("Expense with ID " + expenseID + " deleted successfully.");
                    } catch (DaoException e) {
                        System.out.println("Error deleting expense: " + e.getMessage());
                    }
                    break;

                case "5":
                    // -------- add a new income
                    System.out.print("Enter the title of the income: ");
                    String incomeTitle = scanner.nextLine();
                    System.out.print("Enter the source of the income (e.g., Salary, Side Job, Winnings, etc.): ");
                    String incomeSource = scanner.nextLine();
                    System.out.print("Enter the amount of the income: ");
                    double incomeAmount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter the date of the income (YYYY-MM-DD): ");
                    String incomeDateStr = scanner.nextLine();
                    Date incomeDate = Date.valueOf(incomeDateStr);
                    Income newIncome = new Income(incomeTitle, incomeSource, incomeAmount, incomeDate);

                    try {
                        incomeDAO.addIncome(newIncome);
                        System.out.println("New income added successfully.");
                    } catch (DaoException e) {
                        System.out.println("Error adding income: " + e.getMessage());
                    }
                    break;

                case "6":
                    // -------- add a new expense
                    System.out.print("Enter the title of the expense: ");
                    String expenseTitle = scanner.nextLine();
                    System.out.print("Enter the category of the expense (e.g., Bills, Entertainment, etc.): ");
                    String expenseCategory = scanner.nextLine();
                    System.out.print("Enter the amount of the expense: ");
                    double expenseAmount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter the date of the expense (YYYY-MM-DD): ");
                    String expenseDateStr = scanner.nextLine();
                    Date expenseDate = Date.valueOf(expenseDateStr);
                    Expense newExpense = new Expense(expenseTitle, expenseCategory, expenseAmount, expenseDate);
                    try {
                        expenseDAO.addExpense(newExpense);
                        System.out.println("New expense added successfully.");
                    } catch (DaoException e) {
                        System.out.println("Error adding expense: " + e.getMessage());
                    }
                    break;

                case "7":
                    // --------- examine income and expenses by month
                    break;

                case "8":
                    finished = true;
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        scanner.close();
    }
}
