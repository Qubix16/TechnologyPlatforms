import java.util.Optional;

public class MageController {
    private MageRepository repository;
    public MageController(MageRepository repository)
    {
        this.repository = repository;
    }

    public MageRepository getRepository() {
        return repository;
    }

    public void setRepository(MageRepository repository) {
        this.repository = repository;
    }

    public String find(String name) {
        Optional<Mage> obj = repository.find(name);
        if(!obj.isPresent())
        {
            return "not found";
        }
        else
        {
            String objToString = "Mage Name: " + obj.get().getName() + " Level: " + obj.get().getLevel();
            return objToString;
        }
    }
    public String delete(String name) {
        try
        {
            repository.delete(name);
            return "done";
        }
        catch(IllegalArgumentException ex)
        {
            return "not found";
        }

    }
    public String save(String name, int level) {
        try
        {
            Mage newMage = new Mage(name,level);
            repository.save(newMage);
            return "done";
        }
        catch(IllegalArgumentException ex)
        {
            return "bad request";
        }
    }
}