package org.example.oopjavafxuserdetailsdao.DAOs;

import org.example.oopjavafxuserdetailsdao.DTOs.Expense;
import org.example.oopjavafxuserdetailsdao.Exceptions.DaoException;
import java.util.List;

public interface ExpenseDaoInterface {
    List<Expense> findAllExpenses() throws DaoException;
    int insertExpense(Expense expense) throws DaoException;
}