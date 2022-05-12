import java.util.Collection;
import java.util.Optional;

public class MageRepository
{
    private Collection<Mage> collection;

    public MageRepository(Collection<Mage> collection)
    {
        this.collection = collection;
    }

    public Collection<Mage> getCollection()
    {
        return collection;
    }

    public void setCollection(Collection<Mage> collection)
    {
        this.collection = collection;
    }

    public Optional<Mage> find(String name)
    {
        for (Mage mage:collection)
        {
            if(mage.getName().compareTo(name) == 0)
            {
                return Optional.of(mage);
            }
        }
        return Optional.ofNullable(null);
    }
    public void delete(String name)
    {
        int ex = 1;
        for (Mage mage:collection)
        {
            if(mage.getName().compareTo(name) == 0)
            {
                collection.remove(mage);
                ex = 0;
                break;
            }
        }
        if(ex == 1) {
            throw new IllegalArgumentException();
        }

    }
    public void save(Mage mage1)
    {
        int ex = 0;
        for (Mage mage:collection)
        {
            if(mage.getName().compareTo(mage1.getName()) == 0)
            {
                ex = 1;
                throw new IllegalArgumentException();
            }
        }
        if(ex == 0)
        {
            collection.add(mage1);
        }
    }
}