package assignmentfour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDisplayStudents {

    public static void main(String[] args) {

        // Database details
        String url = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "NKit1703";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");

            // 3. SQL Select Query
            String sql =
                "SELECT * FROM Students " +
                "WHERE semester = ? AND branch = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, 7);
            ps.setString(2, "EC");

            // 4. Execute Query
            rs = ps.executeQuery();

            // 5. Display Records
            boolean found = false;
            System.out.println("\nStudents of Semester 7 (EC):");
            System.out.println("-------------------------------------");

            while (rs.next()) {
                found = true;
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Branch: " + rs.getString("branch") +
                    ", Semester: " + rs.getInt("semester") +
                    ", Percentage: " + rs.getFloat("percentage") +
                    ", Year: " + rs.getInt("year_of_passing")
                );
            }

            if (!found) {
                System.out.println("No records found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
