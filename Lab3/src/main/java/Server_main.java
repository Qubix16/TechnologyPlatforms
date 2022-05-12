public class Server_main
{
    public static void main(String[] args)
    {
        Server server = new Server(8080,1);
        Thread thread = new Thread(server);
        thread.start();

    }
}
