package assignmentfour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcCreateInsertDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "NKit1703";

        Connection con = null;
        Statement stmt = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");

            // 3. Create Statement
            stmt = con.createStatement();

            // 4. Create Table
            String createTable =
                    "CREATE TABLE IF NOT EXISTS Students (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT, " +
                    "course VARCHAR(50))";

            stmt.executeUpdate(createTable);
            System.out.println("Table Students created successfully");

            // 5. Insert Records
            String insert1 =
                    "INSERT INTO Students VALUES (1, 'Ankit', 22, 'Java')";
            String insert2 =
                    "INSERT INTO Students VALUES (2, 'Rahul', 21, 'Python')";
            String insert3 =
                    "INSERT INTO Students VALUES (3, 'Neha', 23, 'Spring')";

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            stmt.executeUpdate(insert3);

            System.out.println("Records inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close resources
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
