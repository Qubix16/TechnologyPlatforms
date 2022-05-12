import java.util.ArrayList;
import java.util.List;

public class Collection
{
    private List<Result> numbers = new ArrayList<>();

    public synchronized void add(Boolean isPrime,Integer number)
    {
        Result result = new Result();
        result.setPrime(isPrime);
        result.setValue(number);
        numbers.add(result);
    }
    public void show()
    {
        for(Result result: numbers)
        {
            if(result.getPrime())
            {
                System.out.println("Liczba "+result.getValue() + " jest liczbą pierwszą");
            }
            else
            {
                System.out.println("Liczba "+result.getValue() + " nie jest liczbą pierwszą");
            }
        }
    }
}
