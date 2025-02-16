package DAOs;

import DTOs.Expense;
import Exceptions.DaoException;
import java.sql.*;
import java.util.List;

public interface ExpenseInterface {
    List<Expense> listAllExpenses() throws DaoException;
    void addExpense(Expense expense) throws DaoException;
    void deleteExpense(int id) throws DaoException;
    double getTotalExpense() throws DaoException;
    double getExpenseForMonth(int month, int year) throws DaoException;
}


