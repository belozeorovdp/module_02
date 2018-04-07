package task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBD
{
    private String stringNamePath     = null;
    private String stringNameBD       = null;

    public CreateBD(String stringNamePath)
    {
        this.stringNamePath = stringNamePath;
    }

    public void ParsingNameBD()
    {
        stringNameBD  = FileManipulation.getLastNamePathDirectoryOrFile(stringNamePath);
        System.out.println(stringNameBD);
    }

    public void CreateDataBase()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "dima");
            Statement stmt = null;
            stmt = connection.createStatement();
            int Result = stmt.executeUpdate("CREATE DATABASE " + stringNameBD + ";");

            stmt.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
