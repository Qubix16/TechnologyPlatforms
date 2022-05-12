import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


public class Server implements Runnable
{
    private final ServerSocket server;
    private Integer free_space;
    private List<Thread> threads = new ArrayList<Thread>();

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public Integer getFree_space() {
        return free_space;
    }

    public void setFree_space(Integer free_space) {
        this.free_space = free_space;
    }

    public Server(int port, Integer free_space)
    {
        try
        {
            this.free_space = free_space;
            server = new ServerSocket(port);
            //server.setSoTimeout(1000);
        }
        catch (IOException ex)
        {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public void run() {
        //log.info("Staring HTTP listener.");
        while (!Thread.interrupted()) {
            try {
                Socket socket = server.accept();
                if(threads.size() == free_space)
                {
                   System.out.println("New client waiting");
                   while(threads.size()==free_space)
                   {
                        for(Thread watek : threads)
                        {
                            if (!watek.isAlive())
                            {
                                 threads.remove(watek);
                                 break;
                            }
                        }
                   }
                }
                System.out.println("client connected");
                Thread t = new Thread(new Klient(socket,this));
                threads.add(t);
                t.start();
            } catch (SocketTimeoutException ex) {
                //log.log(Level.FINEST, ex.getMessage(), ex);
            } catch (IOException ex) {
                //log.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        //log.info("Stopping HTTP listener.");
    }
}
