import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

public class Klient implements Runnable
{
    private final Socket socket;
    private final Server server;

    public Klient(Socket socket,Server server)
    {
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream serveroutput = socket.getOutputStream();
            ObjectOutputStream obj_server_output = new ObjectOutputStream(serveroutput);

            InputStream serverinput = socket.getInputStream();
            ObjectInputStream obj_server_intput = new ObjectInputStream(serverinput);

            //Sending that server is ready
            String ready = "ready";
            obj_server_output.writeObject(ready);
            obj_server_output.flush();

            //Reading object n
            Integer n = (Integer)obj_server_intput.readObject();

            String readym = "ready for messages";
            obj_server_output.writeObject(readym);
            obj_server_output.flush();


            for (int i = 0 ;i<n;i++)
            {
                Message message = (Message) obj_server_intput.readObject();
                System.out.println("client: "+message.getContent() + message.getNumber());
            }
            String finish = "finished";
            obj_server_output.writeObject(finish);
            obj_server_output.flush();

            //InputStreamReader in = new InputStreamReader(socket.getInputStream());
            //BufferedReader bf = new BufferedReader(in);
            //String str = bf.readLine();
            //System.out.println("client: "+str);
            //System.out.println("1");



        } catch (IOException ex)
        {
            //log.log(Level.WARNING, ex.getMessage(), ex);
        }
        catch (ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }

}
