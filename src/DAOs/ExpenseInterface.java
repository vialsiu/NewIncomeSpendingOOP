package DAOs;

import java.util.List;
import java.util.Date;
import DTOs.Expense;
import Exceptions.DaoException;

public interface ExpenseInterface {
    void addExpense(Expense expense) throws DaoException;
    void deleteExpense(int expenseID) throws DaoException;
    List<Expense> listAllExpenses() throws DaoException;
    double calculateTotalExpenses() throws DaoException;
    List<Expense> listExpensesByMonth(int month, int year) throws DaoException;
}

