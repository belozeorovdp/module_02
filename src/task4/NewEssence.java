package task4;

import java.sql.*;

public class NewEssence
{
    public static void createTable(String nameBD, String nameTable)
    {
        String query = "CREATE TABLE " +
                        nameTable +
                       " (id INT AUTO_INCREMENT, PRIMARY KEY (id));";
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

    public static void addColumnTable(String nameBD, String nameTable, String nameColumn, String typeColumn)
    {
        String query = "ALTER TABLE " +
                       nameTable +
                       " ADD " +
                       nameColumn +
                       " " +
                       typeColumn + ";";
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
    public static void addForeignKeyTable(String nameBD, String nameTable, String nameTableExternal, String strColumn, String strColumnExternal)
    {
        String query = "ALTER TABLE " +
                nameTable +
                " ADD FOREIGN KEY " +
                strColumn +
                "REFERENCES " +
                nameTableExternal +
                "(" +
                strColumnExternal +
                ");";
        System.out.println(query);
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            statement.executeUpdate("SET foreign_key_checks = 0;");
            statement.executeUpdate(query);
            statement.executeUpdate("SET foreign_key_checks = 1;");
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void insertDataTable(String nameBD, String nameTable, String strData)
    {
        String query = "INSERT INTO " +
                       nameTable +
                       " VALUES(" +
                       strData + ");";
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

    public static void sendingSelectAllTable(String nameBD, String nameTable)
    {
        String query = "SELECT * FROM " + nameTable + ";";
        System.out.println(query);
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

    public static void sendingSelect(String nameBD, String query)
    {
        System.out.println(query);
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

    public static void dropTable(String nameBD, String nameTable)
    {
        String query = "DROP TABLE "+ nameTable + ";";
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


    public static boolean sendingQueryCheckRow(String nameBD, String nameTable, String photo,  int id_photo, String user, int id_name)
    {
        // "SELECT id FROM likephotos WHERE id_photos = " + id_photo + " AND id_users = " + id_name + ";";
        String query = "SELECT id FROM " + nameTable + " WHERE " + photo + " = " + id_photo + " AND  " + user + " = " + id_name + ";";
        System.out.println(query);
        boolean result = true;
        int id = -1;
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (!rs.isBeforeFirst())
            {
                System.out.println("No data");
                result = false;
                id = -2;
            }
            else
            {
                while(rs.next())
                {
                    id = rs.getInt(1);
                    System.out.println();
                }
            }
            rs.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("Не найдено.");
            e.printStackTrace();
        }

        return result;
    }

    public static int sendingQueryIdlike(String nameBD, String nameTable, String users,  int id_name, String commentstophoto, int id_commentstophoto)
    {
        String query = "SELECT id FROM " + nameTable + " WHERE  " + commentstophoto + " = " + id_commentstophoto + " AND " + users + " = " + id_name + ";";

        System.out.println(query);

        int id = -1;
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (!rs.isBeforeFirst())
            {
                System.out.println("No data");
                id = -2;
            }
            else
            {
                while(rs.next())
                {
                    id = rs.getInt(1);
                    System.out.println();
                }

            }
            rs.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("Не найдено.");
            e.printStackTrace();
        }
        return id;
    }

    public static int sendingQuerySumlike(String nameBD, String query)
    {
        // для commentstophotoslike (для проверки)
        query = "SELECT users.name, SUM(commentstophotoslike.like_) FROM likephotos RIGHT OUTER JOIN users ON users.id = commentstophotoslike.id_users AND commentstophotoslike.like_ > 0;";

        System.out.println(query);

        int id = -1;
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
        return id;
    }


    public static int sendingQueryCheckRowLikePhoto (String nameBD, String nameTable, int id_name, String users, int id_photo, String photo)
    {
        String query = "SELECT like_ FROM " + nameTable + " WHERE " + photo + " = " + id_photo + " AND " + users + " = " + id_name + ";";
        int like = -1;
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (!rs.isBeforeFirst())
            {
                System.out.println("No data");
                like = -2;
            }
            else
            {
                while(rs.next())
                {
                    like = rs.getInt(1);
                    System.out.println();
                }

            }
            rs.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println("Не найдено.");
            e.printStackTrace();
        }

        return like;
    }
}
