package org.example.oopjavafxuserdetailsdao.DAOs;

import org.example.oopjavafxuserdetailsdao.DTOs.Expense;
import org.example.oopjavafxuserdetailsdao.Exceptions.DaoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO extends MySqlDao implements ExpenseDaoInterface {

    @Override
    public List<Expense> findAllExpenses() throws DaoException {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM expenses";

        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Expense expense = new Expense(
                        rs.getInt("expenseID"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getDouble("amount"),
                        rs.getDate("dateIncurred")
                );
                expenses.add(expense);
            }
        } catch (SQLException ex) {
            throw new DaoException("findAllExpenses() failed: " + ex.getMessage());
        }
        return expenses;
    }

    @Override
    public int insertExpense(Expense expense) throws DaoException {
        String query = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";

        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, expense.getTitle());
            stmt.setString(2, expense.getCategory());
            stmt.setDouble(3, expense.getAmount());
            stmt.setDate(4, expense.getDateIncurred());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            throw new DaoException("insertExpense() failed: " + ex.getMessage());
        }
        return -1; // Return -1 if no ID was generated
    }

    @Override
    public boolean deleteExpenseById(int id) throws DaoException {
        String query = "DELETE FROM expenses WHERE expenseID = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            throw new DaoException("deleteExpenseById() failed: " + ex.getMessage());
        }
    }
}