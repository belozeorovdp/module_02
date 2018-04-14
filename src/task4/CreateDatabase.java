package task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase
{
    public static void create(String nameDatabase)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "dima");
            Statement stmt = null;
            stmt = connection.createStatement();
            stmt.executeUpdate("CREATE DATABASE " + nameDatabase + ";");

            stmt.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
