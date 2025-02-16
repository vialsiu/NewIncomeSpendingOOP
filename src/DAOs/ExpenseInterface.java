package DAOs;

import java.util.List;
import java.util.Date;
import DTOs.Expense;

public interface ExpenseInterface {
    void addExpense(Expense expense);
    void deleteExpense(int expenseID);
    List<Expense> listAllExpenses();
    double calculateTotalExpenses();
    List<Expense> listExpensesByMonth(int month, int year);
}
