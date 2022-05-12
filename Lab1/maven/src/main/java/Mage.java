import java.util.*;

public class Mage implements Comparable<Mage>
{
    private String name;
    private int level;
    private double power;
    private Set<Mage> apprentices;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public Set<Mage> getApprentices() {
        return apprentices;
    }

    public void setApprentices(Set<Mage> apprentices) {
        this.apprentices = apprentices;
    }
    public void setSet(int tryb)
    {
            if(tryb == 1)
            {
                this.apprentices = new HashSet<Mage>();

            }
            else if (tryb == 2)
            {
                this.apprentices = new TreeSet<Mage>();
            }
            else
            {
                this.apprentices = new TreeSet<Mage>(new MageComparator());
            }

    }
    public Mage(String name, int level, double power)
    {
        this.name = name;
        this.level = level;
        this.power = power;
    }
    public void PrintAll()
    {
        System.out.println(this.toString());
        for(Mage o :this.getApprentices())
        {
            o.PrintAll();
        }

    }
    public int GenerateMap(Map Map)
    {
        int children = 0;
        children = this.getApprentices().size();
        for(Mage o :this.getApprentices())
        {
            children += o.GenerateMap(Map);
        }
        Map.put(this,children);
        return children;
    }

    @Override
    public int hashCode()
    {
        int hash;
        if(this.name == null)
        {
            hash = 0;
        }
        else
        {
            hash = this.name.hashCode();
        }
        hash = hash * 71 + (int)this.power;

        return hash;
    }
    @Override
    public boolean equals(Object other)
    {
        if(this == other)
        {
            return true;
        }
        if(other == null || this.getClass() != other.getClass())
        {
            return false;
        }
        Mage newMage = (Mage)other;
        if(this.level != newMage.level)
        {
            return false;
        }
        if(this.power != newMage.power)
        {
            return false;
        }
        if(this.apprentices != newMage.apprentices)
        {
            return false;
        }
        if(this.name != null ? !this.name.equals(newMage.name) : newMage.name != null)
        {
            return false;
        }
        return true;
    }
    @Override
    public String toString()
    {
        return "Mage "+"Name: "+this.name+" "+"Level: "+this.level+" "+"Power: "+this.power;
    }

    @Override
    public int compareTo(Mage other)
    {
        int ret = name.compareTo(other.name);
        if(ret == 0)
        {
            ret = this.level - other.level;
        }
        if(ret == 0)
        {
            if((this.power - other.power) == 0)
            {
                ret = 0;
            }
            else if((this.power - other.power)> 0)
            {
                ret = 2;
            }
            else if((this.power - other.power)< 0)
            {
                ret = -2;
            }
        }
        return ret;
    }

}
