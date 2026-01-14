package assignmentfour;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionDemo {
    
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "@Nkit1703";

        Connection con = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Connection Successful");
            } else {
                System.out.println("Unable to connect");
            }

        } catch (Exception e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        } finally {
            
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
