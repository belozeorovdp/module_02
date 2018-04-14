package task4;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Проверка работы
        String NameBD = "base17";

        CreateDatabase.create(NameBD);

        CreateTables.createTable1Users(NameBD);
        CreateTables.createTable2Photos(NameBD);
        CreateTables.createTable3CommentsToPhoto(NameBD);
        CreateTables.createTable4LikePhotos(NameBD);

        InsertTables.insertTable1Users(NameBD);
        InsertTables.insertTable2Photos(NameBD);
        InsertTables.insertTable3CommentsToPhoto(NameBD);


        Scanner scan = new Scanner(System.in);
        System.out.println("Name user:");
        // String strName = scan.nextLine();
        String strName = "Ivanov";

        // Предполагаем, что имена уникальные
        // 1. Определяем id User-а
        int id_name = SelectQuery.sendingQueryId(NameBD, strName);
        System.out.println("Name:" + strName + ", " + id_name);
        // 2. Определяем id Photo (Title + Author - не повторяются)
        System.out.println("Author:");
        // String strAuthor = scan.nextLine();
        String strAuthor = "A";
        System.out.println(strAuthor);
        System.out.println("Photo Title:");
        // String strTitle = scan.nextLine();
        String strTitle =  "aa";
        System.out.println(strTitle);
        int id_photo = SelectQuery.sendingQueryIdPhotos(NameBD, strTitle, strAuthor);
        System.out.println("id_photo: " + id_photo);
        // 3. Существует ли строка в таблице "likephotos" с лайком id_user (user), id_photo(photo)
        if (!SelectQuery.sendingQueryCheckRow(NameBD, id_name, id_photo))
        {
            // если нет, создаем like
            InsertTables.insertTableLikePhotos(NameBD, id_name, id_photo, 1);
            // просмотр таблицы
            // NewEssence.sendingSelectAllTable(NameBD,"likephotos");
        }
        else
        {
            // если существует, проверяем чему равен like (like == 1 (уже есть), like == 0 (был когда то отозван))
            if (SelectQuery.sendingQueryCheckRowLikePhoto(NameBD, id_name, id_photo) == 0)
            {
                // востанавливаем like
                int id = SelectQuery.sendingQueryIdlikephotos(NameBD, id_photo ,id_name);
                UpdateTables.updateLikePhotos( NameBD,"likephotos",id, 1);
            }
        }

        // 5. Число полученных сущностью лайков и вывести список Пользователей, поставивших лайки
        SelectQuery.sendingQuerySumlikephotos(NameBD);


        //  4. отозвать like
        if (SelectQuery.sendingQueryCheckRowLikePhoto(NameBD, id_name, id_photo)  > 0)
        {
            int id = SelectQuery.sendingQueryIdlikephotos(NameBD, id_photo ,id_name);
            UpdateTables.updateLikePhotos( NameBD,"likephotos",id, 0);
        }

        // класс  NewEssence для новых видов сущностей
        String strtable = "commentstophotoslike";
        NewEssence.createTable(NameBD, strtable);
        NewEssence.addColumnTable(NameBD, strtable, "id_users",  "INT");
        NewEssence.addColumnTable(NameBD, strtable, "id_commentstophoto",  "INT");
        NewEssence.addColumnTable(NameBD, strtable, "like_",  "INT");
        NewEssence.addForeignKeyTable(NameBD, strtable, "users", "id_users", "id");
        NewEssence.addForeignKeyTable(NameBD, strtable, "commentstophoto", "id_commentstophoto", "id");
        // можно проводить похожие манипуляции п.1-5 (похожие методы внутри класса NewEssence)

    }
}
