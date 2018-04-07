package task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckedDB
{
    public static boolean checked(String nameBD)
    {
        nameBD = FileManipulation.getLastNamePathDirectoryOrFile(nameBD);
        boolean databaseFound = true;
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            connection.close();
            databaseFound = true;
            return  databaseFound;
        }
        catch (SQLException e)
        {
            databaseFound =false;
            e.printStackTrace();
            return  databaseFound;
        }
    }
 }
