package assignmentfour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcUpdatePercentage {

    public static void main(String[] args) {

        // Database details
        String url = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "NKit1703";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");

            // 3. SQL Query to increase percentage by 5% for CSE students
            String sql =
                "UPDATE Students " +
                "SET percentage = percentage + 5 " +
                "WHERE branch = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, "CSE");

            // 4. Execute Update
            int rowsUpdated = ps.executeUpdate();

            // 5. Result
            if (rowsUpdated > 0) {
                System.out.println("Percentage increased by 5% for CSE students");
                System.out.println("Number of students updated: " + rowsUpdated);
            } else {
                System.out.println("No CSE students found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close resources
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
