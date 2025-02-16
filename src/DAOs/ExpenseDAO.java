package DAOs;

import DTOs.Expense;
import Exceptions.DaoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO implements ExpenseInterface {

    private MySQLDao mySQLDao;

    public ExpenseDAO() {
        mySQLDao = new MySQLDao();
    }

    // -------- connection
    private Connection getConnection() throws DaoException {
        return mySQLDao.getConnection();
    }

    @Override
    public void addExpense(Expense expense) throws DaoException {
        String query = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, expense.getTitle());
            preparedStatement.setString(2, expense.getCategory());
            preparedStatement.setDouble(3, expense.getAmount());
            preparedStatement.setDate(4, expense.getDateIncurred());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("addExpense() " + e.getMessage());
        }
    }

    @Override
    public void deleteExpense(int expenseID) throws DaoException {
        String query = "DELETE FROM expenses WHERE expenseID = ?";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, expenseID);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Expense deleted successfully.");
            } else {
                System.out.println("No expense found with the given ID.");
            }
        } catch (SQLException e) {
            throw new DaoException("deleteExpense() " + e.getMessage());
        }
    }

    @Override
    public List<Expense> listAllExpenses() throws DaoException {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM expenses";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("expenseID");
                String title = resultSet.getString("title");
                String category = resultSet.getString("category");
                double amount = resultSet.getDouble("amount");
                Date dateIncurred = resultSet.getDate("dateIncurred");

                expenses.add(new Expense(id, title, category, amount, dateIncurred));
            }
        } catch (SQLException e) {
            throw new DaoException("listAllExpenses() " + e.getMessage());
        }
        return expenses;
    }

    @Override
    public double getTotalExpense() throws DaoException {
        String query = "SELECT SUM(amount) AS total FROM expenses";
        double totalExpense = 0;

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalExpense = resultSet.getDouble("total");
            }
        } catch (SQLException e) {
            throw new DaoException("getTotalExpense() " + e.getMessage());
        }
        return totalExpense;
    }

    @Override
    public double getExpenseForMonth(int month, int year) throws DaoException {
        String query = "SELECT SUM(amount) AS total FROM expenses WHERE MONTH(dateIncurred) = ? AND YEAR(dateIncurred) = ?";
        double totalExpense = 0;

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, month);
            preparedStatement.setInt(2, year);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalExpense = resultSet.getDouble("total");
            }
        } catch (SQLException e) {
            throw new DaoException("getExpenseForMonth() " + e.getMessage());
        }
        return totalExpense;
    }
}
