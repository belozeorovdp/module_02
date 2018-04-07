package task3;

public class ParsingFileTxt
{
    public static String[] parsingString(String string)
    {
        String delimiter = " |\\(|\\)|\\):";
        return string.split(delimiter);
    }
}
