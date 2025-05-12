
package travel.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load MySQL JDBC driver (com.mysql.cj.jdbc.Driver)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Updated JDBC URL to use port 3307 and the 'tms' database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3307/tms", "root", "root");

            // Create statement
            s = c.createStatement();

        } catch (Exception e) {
            // Print the exception if any error occurs
            System.out.println(e);
        }
    }
}
