package DAOs;

import Exceptions.DaoException;
import java.sql.*;

public class MySqlDao {
    public Connection getConnection() throws DaoException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/finance_tracker";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Connection failed: " + e.getMessage());
        }
    }

    public void freeConnection(Connection connection) throws DaoException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DaoException("Failed to free connection: " + e.getMessage());
        }
    }
}