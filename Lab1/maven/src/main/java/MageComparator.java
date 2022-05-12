import java.util.*;
public class MageComparator implements Comparator <Mage>
{
    @Override
    public int compare(Mage m1,Mage m2)
    {
        int ret = m1.getLevel() - m2.getLevel();
        if(ret == 0)
        {
            ret = m1.getName().compareTo(m2.getName());
        }
        if(ret == 0)
        {
            if((m1.getPower() - m2.getPower()) == 0)
            {
                ret = 0;
            }
            else if((m1.getPower() - m2.getPower())> 0)
            {
                ret = 2;
            }
            else if((m1.getPower() - m2.getPower())< 0)
            {
                ret = -2;
            }
        }
        return ret;
    }
}
