import org.junit.Test;
import java.util.ArrayList;
import java.util.Optional;


public class MageRepositoryTest
{

    @Test
    public void MageRepositoryTest_Find_Not_Empty()
    {
        ArrayList<Mage> col = new ArrayList();
        Mage newMage1 = new Mage("JD1",1);
        col.add(newMage1);
        MageRepository rep = new MageRepository(col);
        Optional<Mage> result = rep.find("JD1");
        assert result.isPresent() : "Object is empty";
    }

    @Test
    public void MageRepositoryTest_Find_Empty()
    {
        ArrayList<Mage> col = new ArrayList();
        MageRepository rep = new MageRepository(col);
        Optional<Mage> result = rep.find("JD1");
        assert !result.isPresent() : "Object is not empty";
    }

    @Test(expected=Exception.class)
    public void MageRepositoryTest_Delete()
    {
        ArrayList<Mage> col = new ArrayList();
        MageRepository rep = new MageRepository(col);
        rep.delete("JD1");
    }

    @Test(expected=Exception.class)
    public void MageRepositoryTest_Save()
    {
        ArrayList<Mage> col = new ArrayList();
        Mage newMage1 = new Mage("JD1",1);
        col.add(newMage1);
        MageRepository rep = new MageRepository(col);
        rep.save(newMage1);
    }


}
