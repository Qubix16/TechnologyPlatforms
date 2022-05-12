import java.util.ArrayList;
import java.util.List;


public class Zasob
{
    private List<Number> numbers = new ArrayList<>();


    public synchronized Number take() throws InterruptedException
    {
        while (numbers.isEmpty()) {
            wait();
        }

        Number ret = numbers.remove(0);
        return ret;
    }

    public synchronized void put(Number number)
    {
        this.numbers.add(number);
        notifyAll();
    }
}
