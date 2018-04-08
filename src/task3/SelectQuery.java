package task3;

import java.io.*;
import java.sql.*;

public class SelectQuery
{
    public static void sendingQuery(String nameBD, String query)
    {
        System.out.println(query);

        nameBD = FileManipulation.getLastNamePathDirectoryOrFile(nameBD);

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();
            if (!rs.isBeforeFirst())
            {
                System.out.println("No data");
            }
            while(rs.next())
            {
                for (int i = 1; i <= columns; i++)
                {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            System.out.println();
            rs.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("Не найдено.");
            e.printStackTrace();
        }
    }

    public static String readUsingBufferedReader(File fileName)
    {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        try
        {
            while( (line = reader.readLine()) != null )
            {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}