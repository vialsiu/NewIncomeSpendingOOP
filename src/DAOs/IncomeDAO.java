package DAOs;

import DTOs.Income;
import Exceptions.DaoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO implements IncomeInterface {

    private MySQLDao mySQLDao;

    public IncomeDAO() {
        //-------instanciated
        mySQLDao = new MySQLDao();
    }

        //------ new connection to finance_dept
    private Connection getConnection() throws DaoException {
        return mySQLDao.getConnection();
    }

    @Override
    public List<Income> findAllIncome() throws DaoException {
        List<Income> incomeList = new ArrayList<>();
        String query = "SELECT * FROM income";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("incomeID");
                String title = resultSet.getString("title");
                String source = resultSet.getString("source");
                double amount = resultSet.getDouble("amount");
                Date dateEarned = resultSet.getDate("dateReceived");

                incomeList.add(new Income(id, title, source, amount, dateEarned));
            }
        } catch (SQLException e) {
            throw new DaoException("findAllIncome() " + e.getMessage());
        }
        return incomeList;
    }

    @Override
    public void addIncome(Income income) throws DaoException {
        String query = "INSERT INTO income (title, source, amount, dateReceived) VALUES (?, ?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, income.getTitle());
            preparedStatement.setString(2, income.getSource());
            preparedStatement.setDouble(3, income.getAmount());
            preparedStatement.setDate(4, income.getDateReceived());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("addIncome() " + e.getMessage());
        }
    }

    @Override
    public void deleteIncome(int id) throws DaoException {
        String query = "DELETE FROM income WHERE incomeID = ?";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Income deleted successfully.");
            } else {
                System.out.println("No income found with the given ID.");
            }
        } catch (SQLException e) {
            throw new DaoException("deleteIncome() " + e.getMessage());
        }
    }

    @Override
    public double getTotalIncome() throws DaoException {
        String query = "SELECT SUM(amount) AS total FROM income";
        double totalIncome = 0;

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalIncome = resultSet.getDouble("total");
            }
        } catch (SQLException e) {
            throw new DaoException("getTotalIncome() " + e.getMessage());
        }
        return totalIncome;
    }

    @Override
    public double getIncomeForMonth(int month, int year) throws DaoException {
        String query = "SELECT SUM(amount) AS total FROM income WHERE MONTH(dateReceived) = ? AND YEAR(dateReceived) = ?";
        double totalIncome = 0;

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, month);
            preparedStatement.setInt(2, year);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalIncome = resultSet.getDouble("total");
            }
        } catch (SQLException e) {
            throw new DaoException("getIncomeForMonth() " + e.getMessage());
        }
        return totalIncome;
    }
}
