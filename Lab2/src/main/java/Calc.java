import java.util.ArrayList;
import java.util.List;

public class Calc implements Runnable
{
        private Collection collection;
        private Zasob zasoby;


        public Calc(Collection collection, Zasob zasoby)
        {
            this.collection = collection;
            this.zasoby = zasoby;

        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try
                {
                    Number number = zasoby.take();
                    Thread.sleep(number.getTime());
                    this.collection.add(licz(number.getNumber()),number.getNumber());

                } catch (InterruptedException ex)
                {
                    break;
                }
            }
        }
        private Boolean licz(Integer number)
        {
            Integer licznik = 0;
            for(int i = 1; i <= number;i++)
            {
              if(number % i == 0)
              {
                  licznik = licznik + 1;
              }
            }
            if(licznik == 2)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

}
