package task3;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDB
{
    public static void delete(String nameBD)
    {
        nameBD = FileManipulation.getLastNamePathDirectoryOrFile(nameBD);


        String query = "DROP DATABASE " + nameBD + ";";
        System.out.println(query);

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
