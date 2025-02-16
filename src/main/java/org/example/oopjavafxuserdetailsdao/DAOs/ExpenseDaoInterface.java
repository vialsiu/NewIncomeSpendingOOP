package org.example.oopjavafxuserdetailsdao.DAOs;

import org.example.oopjavafxuserdetailsdao.DTOs.Expense;
import org.example.oopjavafxuserdetailsdao.Exceptions.DaoException;
import java.util.List;

public interface ExpenseDaoInterface {
    int insertExpense(Expense expense) throws DaoException;
    List<Expense> findAllExpenses() throws DaoException;
    boolean deleteExpenseById(int id) throws DaoException;
}