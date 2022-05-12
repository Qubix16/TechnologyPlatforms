import java.util.*;

public class Maven
{
    public static void main(String[] args)
    {
        int tryb = 0;
        if(args.length>=1)
        {
            tryb = Integer.parseInt(args[0]);
        }

        if(tryb != 0)
        {
            //poziom 1
            Mage m1 = new Mage("(0)Jakub",9,3.5);
            //poziom 2
            Mage m2 = new Mage("(1)Heimer",3,4.5);
            Mage m3 = new Mage("(2)Veigar",2,7.5);
            Mage m4 = new Mage("(3)Sylas",1,9.5);
            //poziom 3
            Mage m5 = new Mage("(4)Ahri",5,3.5);
            Mage m6 = new Mage("(5)Malzahar",6,10.5);
            Mage m7 = new Mage("(6)Ziggs",2,3.5);
            Mage m8 = new Mage("(7)Lux",4,5.5);
            Mage m9 = new Mage("(8)Morgana",6,7.5);
            Mage m10 = new Mage("(9)Lulu",4,1.5);


            if(tryb == 1)//brak sortowania
            {
               m1.setSet(1);
               m2.setSet(1);
               m3.setSet(1);
               m4.setSet(1);
               m5.setSet(1);
               m6.setSet(1);
               m7.setSet(1);
               m8.setSet(1);
               m9.setSet(1);
               m10.setSet(1);
               m1.getApprentices().add(m2);
               m1.getApprentices().add(m3);
               m1.getApprentices().add(m4);
               m2.getApprentices().add(m5);
               m2.getApprentices().add(m6);
               m3.getApprentices().add(m7);
               m3.getApprentices().add(m8);
               m4.getApprentices().add(m9);
               m4.getApprentices().add(m10);
               m1.PrintAll();
               HashMap<Mage,Integer>Map = new HashMap<Mage,Integer>();
               int cos = m1.GenerateMap(Map);
               for (Mage i : Map.keySet())
               {
                   System.out.println("key: " + i + " value: " + Map.get(i));
               }

            }
            else
            {
                if(tryb == 2)//naturalny
                {
                    m1.setSet(2);
                    m2.setSet(2);
                    m3.setSet(2);
                    m4.setSet(2);
                    m5.setSet(2);
                    m6.setSet(2);
                    m7.setSet(2);
                    m8.setSet(2);
                    m9.setSet(2);
                    m10.setSet(2);
                    m1.getApprentices().add(m2);
                    m1.getApprentices().add(m3);
                    m1.getApprentices().add(m4);
                    m2.getApprentices().add(m5);
                    m2.getApprentices().add(m6);
                    m3.getApprentices().add(m7);
                    m3.getApprentices().add(m8);
                    m4.getApprentices().add(m9);
                    m4.getApprentices().add(m10);
                    m1.PrintAll();
                    TreeMap<Mage,Integer> Map = new TreeMap<Mage,Integer>();
                    int cos = m1.GenerateMap(Map);
                    for (Mage i : Map.keySet())
                    {
                        System.out.println("key: " + i + " value: " + Map.get(i));
                    }


                }
                else if(tryb == 3)//alternative
                {
                    m1.setSet(3);
                    m2.setSet(3);
                    m3.setSet(3);
                    m4.setSet(3);
                    m5.setSet(3);
                    m6.setSet(3);
                    m7.setSet(3);
                    m8.setSet(3);
                    m9.setSet(3);
                    m10.setSet(3);
                    m1.getApprentices().add(m2);
                    m1.getApprentices().add(m3);
                    m1.getApprentices().add(m4);
                    m2.getApprentices().add(m5);
                    m2.getApprentices().add(m6);
                    m3.getApprentices().add(m7);
                    m3.getApprentices().add(m8);
                    m4.getApprentices().add(m9);
                    m4.getApprentices().add(m10);
                    m1.PrintAll();
                    TreeMap<Mage,Integer> Map = new TreeMap<Mage,Integer>();
                    int cos = m1.GenerateMap(Map);
                    for (Mage i : Map.keySet())
                    {
                        System.out.println("key: " + i + " value: " + Map.get(i));
                    }
                }
            }
        }

    }
}
