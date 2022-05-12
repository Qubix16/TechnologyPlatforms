import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class MageControllerTest
{
    @Test
    public void MageControllerTest_Working_Delete()
    {
        MageRepository rep = Mockito.mock(MageRepository.class);
        MageController con = new MageController(rep);
        String cos = con.delete("JD1");
        assert cos.compareTo("done") == 0: cos +" is not equal to: \"done\"";
    }
    @Test
    public void MageControllerTest_NotWorking_Delete()
    {
        MageRepository rep = Mockito.mock(MageRepository.class);
        MageController con = new MageController(rep);
        Mockito.doThrow(IllegalArgumentException.class).when(rep).delete(any(String.class));
        String cos = con.delete("JD1");
        assert cos.compareTo("not found") == 0: cos +" is not equal to: \"not found\"";
    }
    @Test
    public void MageControllerTest_Working_Find()
    {

        MageRepository rep = Mockito.mock(MageRepository.class);
        Mockito.when(rep.find("JD1")).thenReturn(Optional.of(new Mage("JD1",1)));
        MageController con = new MageController(rep);
        String cos = con.find("JD1");
        assert cos.compareTo("Mage Name: JD1 Level: 1") == 0: cos +" is not equal to: \"Mage Name: JD1 Level: 1\"";
    }
    @Test
    public void MageControllerTest_NotWorking_Find()
    {

        MageRepository rep = Mockito.mock(MageRepository.class);
        Mockito.when(rep.find("JD1")).thenReturn(Optional.ofNullable(null));
        MageController con = new MageController(rep);
        String cos = con.find("JD1");
        assert cos.compareTo("not found") == 0: cos +cos +" is not equal to: \"not found\"";
    }
    @Test
    public void MageControllerTest_Working_Save()
    {
        MageRepository rep = Mockito.mock(MageRepository.class);
        MageController con = new MageController(rep);
        String cos = con.save("JD1",1);
        assert cos.compareTo("done") == 0: cos +" is not equal to: \"done\"";
    }
    @Test
    public void MageControllerTest_NotWorking_Save()
    {
        MageRepository rep = Mockito.mock(MageRepository.class);
        MageController con = new MageController(rep);
        Mockito.doThrow(IllegalArgumentException.class).when(rep).save(any(Mage.class));
        String cos = con.save("JD1",1);
        assert cos.compareTo("bad request") == 0: cos +" is not equal to: \"bad request\"";
    }
}
