package assignmentfour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcDeleteStudents {

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

            // 3. SQL Delete Query
            String sql =
                "DELETE FROM Students " +
                "WHERE year_of_passing = ? AND branch = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, 2024);
            ps.setString(2, "Civil");

            // 4. Execute Delete
            int rowsDeleted = ps.executeUpdate();

            // 5. Result
            if (rowsDeleted > 0) {
                System.out.println("Records deleted successfully");
                System.out.println("Number of students deleted: " + rowsDeleted);
            } else {
                System.out.println("No matching records found");
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
