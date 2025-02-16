package DAOs;
import DTOs.Income;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO extends MySQLDao {

    // -----fetch
    public List<Income> findAll() {
        ArrayList<Income> incomes = new ArrayList<>();

        try {
            // --------connect
            Connection conn = getConnection();
            String query = "SELECT * FROM income;";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int incomeID = rs.getInt(1);
                String title = rs.getString(2);
                String category = rs.getString(3);
                double amount = rs.getDouble(4);
                Date dateEarned = rs.getDate(5);

                Income income = new Income(incomeID, title, category, amount, dateEarned);
                incomes.add(income);
            }
        }
        catch (SQLException e) {
            System.out.println("An error occurred while accessing the database:");
            e.printStackTrace();
            System.exit(1);
        }

        return incomes;
    }
}
