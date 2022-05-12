import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Main
{
    public static void main(String[] args)
    {
        Tower tower1 = new Tower("Biurko",23,null);
        List<Mage> mages1 = new ArrayList<>();
        Mage mage1 = new Mage("Szef1" ,2 , tower1);
        Mage mage2 = new Mage("Szef2" ,2 , tower1);
        Mage mage3 = new Mage("Szef3" ,2 , tower1);
        Mage mage4 = new Mage("Szef4" ,3 , tower1);
        Mage mage5 = new Mage("Szef5" ,4 , tower1);
        mages1.add(mage1);
        mages1.add(mage2);
        mages1.add(mage3);
        mages1.add(mage4);
        mages1.add(mage5);
        tower1.setMages(mages1);


        Tower tower2 = new Tower("Policja",32,null);
        List<Mage> mages2 = new ArrayList<>();
        mage1 = new Mage("Nie_Szef1" ,2 , tower2);
        mage2 = new Mage("Nie_Szef2" ,2 , tower2);
        mage3 = new Mage("Nie_Szef3" ,2 , tower2);
        mage4 = new Mage("Nie_Szef4" ,3 , tower2);

        mages2.add(mage1);
        mages2.add(mage2);
        mages2.add(mage3);
        mages2.add(mage4);
        tower2.setMages(mages2);



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("browarPu");
        EntityManager based;
        based = emf.createEntityManager();
        based.getTransaction().begin();
        //Wrzucam pierwszy set towerow i magow------------------------
        for (Mage mag:mages1)
        {
            based.persist(mag);
        }
        based.persist(tower1);
        //----------------
        based.getTransaction().commit();
        based.close();


        //Wrzucam drugi set towerow i magow----------------------------
        based = emf.createEntityManager();
        based.getTransaction().begin();
        //--------------
        for (Mage mag:mages2)
        {
            based.persist(mag);
        }
        based.persist(tower2);
        //----------------
        based.getTransaction().commit();
        based.close();


        //Query-------------------------------------------------
        based = emf.createEntityManager();
        Integer value = 2;
        String str_query = "SELECT m FROM Mage m WHERE m.level > :value" ;
        Query query =  based.createQuery(str_query,Mage.class);
        query.setParameter("value",value);
        List<Mage> mages_query = query.getResultList();
        System.out.println("Lista magów gdzie level jest większy od "+ value);
        System.out.println("----------------------------------------");
        for (Mage mag:mages_query)
        {
            System.out.println("Mage\n"+"Name: "+ mag.getName() + "\nLevel: "+mag.getLevel()+"\nTower: "+ mag.getTower().getName());
        }
        System.out.println("----------------------------------------");
        based.close();


        //Wypisywanie pierwszego towera i jego magow przed usuwaniem-----------------------------------
        System.out.println("Wypisywanie pierwszego towera i jego magow przed usuwaniem");
        based = emf.createEntityManager();
        Tower tower = based.find(Tower.class, "Biurko");
        System.out.println("------------------------------------");
        System.out.println("Tower\n"+"Name: "+ tower.getName() + "\nHeight: "+tower.getHeight());
        System.out.println("********Mages that are in this tower:********");
        for (Mage mag:tower.getMages())
        {
            System.out.println("Mage\n"+"Name: "+ mag.getName() + "\nLevel: "+mag.getLevel());
        }
        System.out.println("------------------------------------");
        based.close();


        //Usuwam magow-------------------------------------------------
        String[] mages_to_delete = {"Szef1", "Szef2", "Szef3"};
        based = emf.createEntityManager();
        based.getTransaction().begin();
        for(int i = 0;i< mages_to_delete.length;i++)
        {
            Mage deleted_mage = based.find(Mage.class, mages_to_delete[i]);
            based.remove(based.merge(deleted_mage));
        }
        based.getTransaction().commit();
        based.close();


        //Wypisywanie pierwszego towera i jego magow po usuwaniu-----------------------------------
        System.out.println("Wypisywanie pierwszego towera i jego magow po usuwaniu");
        based = emf.createEntityManager();
        tower = based.find(Tower.class, "Biurko");
        System.out.println("------------------------------------");
        System.out.println("Tower\n"+"Name: "+ tower.getName() + "\nHeight: "+tower.getHeight());
        System.out.println("********Mages that are in this tower:********");
        for (Mage mag:tower.getMages())
        {
            System.out.println("Mage\n"+"Name: "+ mag.getName() + "\nLevel: "+mag.getLevel());
        }
        System.out.println("------------------------------------");
        based.close();


        //Wypisywanie drugiego towera i jego magow przed usuwaniem-----------------------------------
        System.out.println("Wypisywanie drugiego towera i jego magow przed usuwaniem");
        based = emf.createEntityManager();
        tower = based.find(Tower.class, "Policja");
        System.out.println("------------------------------------");
        System.out.println("Tower\n"+"Name: "+ tower.getName() + "\nHeight: "+tower.getHeight());
        System.out.println("********Mages that are in this tower:********");
        for (Mage mag:tower.getMages())
        {
            System.out.println("Mage\n"+"Name: "+ mag.getName() + "\nLevel: "+mag.getLevel());
        }
        System.out.println("------------------------------------");
        based.close();


        //Usuwam towera-----------------------------------------------------
        String tower_to_delete= "Policja";
        based = emf.createEntityManager();
        based.getTransaction().begin();
        Tower deleted_tower = based.find(Tower.class, "Policja");
        for (Mage mage:deleted_tower.getMages())
        {
            based.remove(based.merge(mage));
        }
        based.remove(based.merge(deleted_tower));
        based.getTransaction().commit();
        based.close();


        //Wypisywanie drugiego towera i jego magow po usuwaniem-----------------------------------
        System.out.println("Wypisywanie drugiego towera i jego magow po usuwaniu");
        based = emf.createEntityManager();
        tower = based.find(Tower.class, "Policja");
        if(tower ==  null)
        {
            System.out.println("Tower and all it's Mages have been deleted");
        }

    }
}
