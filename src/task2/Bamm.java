package task2;


public class Bamm extends Thread
{
    private String strBamm = "bamm";
    private String struser ="";
    boolean index = false;

    @Override
    public void run()
    {
        int numberS = 2000;
        while(true)
        {
            if(!Thread.interrupted())	// Проверка прерывания
            {

            }
            else
            {
                return;    // Завершение потока
            }
            try
            {
                Thread.sleep(numberS);
                System.out.println("bamm");
                if (!index)
                {
                    interrupt();
                    System.out.println("Вы проиграли.");
                }
            }
            catch(InterruptedException e)
            {
                return;	  // Завершение потока после прерывания
            }
        }
    }

    public void word(boolean b)
    {
        index = b;
    }
}
