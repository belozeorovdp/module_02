package task3;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CreateTable
{
    public static void createTables(String Path, String nameBD)
    {
        String ext = ".csv";
        File[] files = FileManipulation.findFiles(Path, ext);
        for(File fileFind:files)
        {
            ArrayList<String> arrayList = FileManipulation.ReadFileLineByLine(fileFind);
            createTable(nameBD, fileFind, ParsingFileTable.parsingString(arrayList.get(0))) ;
            insertTable(nameBD, fileFind, arrayList);
        }
    }

    public static void createTable(String nameBD, File file, String[] arrayString)
    {
        nameBD = FileManipulation.getLastNamePathDirectoryOrFile(nameBD);
        String nameTable = FileManipulation.getLastNamePathDirectoryOrFile(file.toString());
        nameTable = nameTable.substring(0, nameTable.lastIndexOf('.'));

        StringBuffer line = new StringBuffer();


        line.append(arrayString[0]).append(" INT, ");
        line.append(arrayString[1]).append("  VARCHAR(255), ");
        line.append(arrayString[2]).append("  INT, ");
        line.append(arrayString[3]).append("   VARCHAR(255) ");

//        for (int i = 1; i < arrayString.length; i++)
//        {
//            line.append(arrayString[i]).append(" VARCHAR(255), ");
//        }

        String query = "CREATE TABLE " +
                nameTable +
                " "  +
                "("  + line + ", PRIMARY KEY (" + arrayString[0] + "));";
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

    public static void insertTable(String nameBD, File file, ArrayList<String> arrayLists)
    {
        nameBD = FileManipulation.getLastNamePathDirectoryOrFile(nameBD);
        String name = FileManipulation.getLastNamePathDirectoryOrFile(file.toString());
        name = name.substring(0, name.lastIndexOf('.'));
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            for(int i = 1; i< arrayLists.size(); i++)
            {
                statement.executeUpdate(insertQueryString(name,ParsingFileTable.parsingString(arrayLists.get(i))));
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static String insertQueryString(String nameTable, String[] arrayString)
    {
        StringBuffer line = new StringBuffer();

        line.append(arrayString[0]).append(",");
        line.append("'").append(arrayString[1]).append("'").append(",");
        line.append(arrayString[2]).append(",");
        line.append("'").append(arrayString[3]).append("'");

//        for (int i = 0; i < arrayString.length; i++)
//        {
//            if (i <= arrayString.length - 2)
//            {
//                line.append("'").append(arrayString[i]).append("', ");
//            }
//            else if (i == arrayString.length - 1)
//            {
//                line.append("'").append(arrayString[i]).append("'");
//            }
//        }
        System.out.println("INSERT INTO " + nameTable + " VALUES(" + line + ");");
        return "INSERT INTO " +
                nameTable     +
                " VALUES(" + line + ");";
    }
}
