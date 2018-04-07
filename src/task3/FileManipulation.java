package task3;

import java.io.*;
import java.util.ArrayList;

public class FileManipulation
{
    public static String getLastNamePathDirectoryOrFile(String namePath)
    {
        return new File(namePath).getName();
    }

    public static File[] findFiles(String dir, String ext)
    {
        File file = new File(dir);
        if(!file.exists())
        {
            System.out.println(dir + " папка не существует");
            return null;
        }

        File[] listFiles = file.listFiles(new MyFileNameFilter(ext));
        if(listFiles.length == 0)
        {
            System.out.println(dir + " не содержит файлов с расширением " + ext);
            return null;
        }
        else
        {
            return listFiles;
        }
    }

    public static class MyFileNameFilter implements FilenameFilter
    {
        private String ext;
        public MyFileNameFilter(String ext)
        {
            this.ext = ext.toLowerCase();
        }

        @Override
        public boolean accept(File dir, String name)
        {
            return name.toLowerCase().endsWith(ext);
        }
    }

    public static ArrayList<String> ReadFileLineByLine(File file)
    {
        ArrayList<String> arrayLists = new ArrayList<String>();
        try
        {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = null;
            do
            {
                line = reader.readLine();
                if (line != null)
                {
                    arrayLists.add(line);
                }
            }
            while (line != null);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return arrayLists;
    }


}
