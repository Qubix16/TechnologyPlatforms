import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Integer thread_size = 0;
        if(args.length>=1)
        {
            thread_size = Integer.parseInt(args[0]);
        }

        Collection collection = new Collection();
        Zasob zadania = new Zasob();

        Calc calculator = new Calc(collection,zadania);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0;i<thread_size;i++)
        {
            threads.add(new Thread(calculator));
        }
        for (Thread thread : threads)
        {
            thread.start();
        }

        String liczba;
        Integer last_przecinek = 0;
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            String numery = scan.nextLine();
            if (numery.compareTo("exit") == 0)
            {
                break;
            }
            last_przecinek = 0;
            for (int i = 0;i<numery.length();i++)
            {

                if(numery.charAt(i) == ',')
                {
                    liczba = numery.substring(last_przecinek,i);
                    Integer number = Integer.parseInt(liczba);
                    //System.out.println(number);
                    Number number1 = new Number(number, 500);
                    zadania.put(number1);
                    last_przecinek = i+1;
                }
                else if(i == numery.length()-1)
                {
                    liczba = numery.substring(last_przecinek,i+1);
                    Integer number = Integer.parseInt(liczba);
                    //System.out.println(number);
                    Number number1 = new Number(number, 500);
                    zadania.put(number1);

                }
            }

        }
        collection.show();
        for (Thread thread : threads)
        {
            thread.interrupt();
        }
    }
}
