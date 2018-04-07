package task3;

public class Main
{
    public static void main(String[] args)
    {
        String dir = "c:\\Users\\User\\IdeaProjects\\BD\\";

        if(CheckedDB.checked(dir)) DeleteDB.delete(dir);
        CreateBD createBD = new CreateBD(dir);
        createBD.ParsingNameBD();
        createBD.CreateDataBase();

        CreateTable.createTables(dir, dir);

        String query = "select * from classroom;";
        SelectQuery.sendingQuery(dir, query);

        String str1 = "1a";
        query = "SELECT * FROM classroom WHERE name = '" + str1 + "';";

        SelectQuery.sendingQuery(dir, query);

        String str2 = "7a";
        query = "SELECT * FROM classroom WHERE name = '" + str2 + "';";

        SelectQuery.sendingQuery(dir, query);
    }

}
