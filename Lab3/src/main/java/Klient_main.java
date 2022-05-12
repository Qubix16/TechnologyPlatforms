import java.net.Socket;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Klient_main
{
    public static void main(String[] args)
    {

        try
        {
            Socket socket = new Socket("localhost", 8080);
            OutputStream clientoutput = socket.getOutputStream();
            ObjectOutputStream obj_client_output = new ObjectOutputStream(clientoutput);

            //Object inputstream
            InputStream clientinput = socket.getInputStream();
            ObjectInputStream obj_client_intput = new ObjectInputStream(clientinput);

            //Reading ready from server
            String ready = (String)obj_client_intput.readObject();
            //InputStreamReader in = new InputStreamReader(socket.getInputStream());
            //BufferedReader bf = new BufferedReader(in);
            //String str = bf.readLine();
            System.out.println("server: "+ready);
            Scanner scan = new Scanner(System.in);
            Integer n = scan.nextInt();

            //Sending object n
            obj_client_output.writeObject(n);
            obj_client_output.flush();


            String readym = (String)obj_client_intput.readObject();
            System.out.println("server: "+readym);

            for (int i = 0 ;i<n;i++)
            {
                Message message = new Message(1+i,"Jd");
                obj_client_output.writeObject(message);
                obj_client_output.flush();
            }
            String end = (String)obj_client_intput.readObject();
            System.out.println("server: "+end);
        }
        catch (IOException | ClassNotFoundException ex)
        {

        }
    }
}
