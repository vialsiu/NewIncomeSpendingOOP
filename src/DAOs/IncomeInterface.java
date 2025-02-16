package DAOs;

import DTOs.Income;
import Exceptions.DaoException;
import java.sql.*;
import java.util.List;

public interface IncomeInterface {
    List<Income> findAllIncome() throws DaoException;
    void addIncome(String title, double amount, Date date) throws DaoException;  // match method signature
    void deleteIncome(int id) throws DaoException;
    double getTotalIncome() throws DaoException;
    double getIncomeForMonth(int month, int year) throws DaoException;
}
