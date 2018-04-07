package task3;

public class ParsingFileTable
{
    public static String[] parsingString(String string)
    {
        String delimiter =",";
        return string.split(delimiter);
    }
}
