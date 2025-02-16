package DAOs;

import Exceptions.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/finance_dept"; // Use your actual database name here
    private String username = "root";
    private String password = "";

    public MySQLDao() {
    }

    public Connection getConnection() throws DaoException {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new DaoException("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            throw new DaoException("Error connecting to database: " + e.getMessage());
        }
        return conn;
    }

    public void freeConnection(Connection conn) throws DaoException {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            throw new DaoException("Error closing connection: " + e.getMessage());
        }
    }
}
