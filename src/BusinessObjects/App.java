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
            System.out.println("7) Examine income and expenses by month.");
            System.out.println("8) Exit.");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // List all incomes
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
                    // List all expenses

                    break;

                case "3":
                    // Delete an income by ID

                    break;

                case "4":
                    // Delete an expense by ID

                    break;

                case "5":
                    // Add a new income
                    break;

                case "6":
                    // Add a new expense (similar to income)

                    break;

                case "7":
                    // Examine income and expenses by month
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
