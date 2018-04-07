package task2;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String str = null;
        Bamm bamm = new Bamm();
        bamm.start();

        Scanner scan = new Scanner(System.in);

        while(bamm.isAlive())
        {
            str = scan.nextLine();
            if (str.equals("") || str == null) {
                bamm.word(true);
            } else {
                bamm.word(false);
            }
        }
        scan.close();
        System.out.println("Вы проиграли");

    }
}
