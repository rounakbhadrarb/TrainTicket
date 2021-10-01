package ConnectionPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDatabase {
    private static Connection con;
    public static Connection getConnection()
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/traindb", "root", "roun123$");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return con;

    }
}
