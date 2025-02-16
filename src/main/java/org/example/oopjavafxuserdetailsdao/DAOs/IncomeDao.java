package org.example.oopjavafxuserdetailsdao.DAOs;

import org.example.oopjavafxuserdetailsdao.DTOs.Income;
import org.example.oopjavafxuserdetailsdao.Exceptions.DaoException;
import java.util.List;

public interface IncomeDao {
    List<Income> getAllIncomes() throws DaoException;
    void addIncome(Income income) throws DaoException;
    boolean deleteIncome(int id) throws DaoException;
}