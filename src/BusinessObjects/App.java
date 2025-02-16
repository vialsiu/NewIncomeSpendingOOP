package BusinessObjects;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    // Call function to display all incomes
                    break;
                case "2":
                    // Call function to display all expenses
                    break;
                case "3":
                    // Call function to delete an income by ID
                    break;
                case "4":
                    // Call function to delete an expense by ID
                    break;
                case "5":
                    // Call function to add a new income
                    break;
                case "6":
                    // Call function to add a new expense
                    break;
                case "7":
                    // Call function to examine income and expenses by month
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
