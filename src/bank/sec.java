
package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sec {
    private final String user = "root";
    private final String password = "Mayouya";
    private final String url = "jdbc:mysql://localhost/bankdatabase";
    public Connection connect() throws SQLException
    {
        return DriverManager.getConnection(url,user,password);
    }
}
