import java.util.ArrayList;
import java.util.Collection;

public class Main
{
    public static void main(String[] args)
    {
        //Mage newMage1 = new Mage("JD1",1);
        //Mage newMage2 = new Mage("JD2",2);
        //Mage newMage3 = new Mage("JD3",3);
        //Mage newMage4 = new Mage("JD4",4);
        //Mage newMage5 = new Mage("JD5",5);
        ArrayList<Mage> col = new ArrayList();
        MageRepository rep = new MageRepository(col);
        MageController con = new MageController(rep);
        System.out.println(con.find("jd"));
        System.out.println(con.save("JD1",1));
        System.out.println(con.save("JD1",1));
        System.out.println(con.delete("JD1"));
        System.out.println(con.save("JD2",3));
        System.out.println(con.find("JD2"));
        System.out.println(con.delete("JD1"));

        //System.out.println(con.find("jd"));
        //System.out.println(con.find("jd"));

    }
}
