import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Serveur
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Serveur exemple v1.0");
            ServerSocket ss = new ServerSocket(7777);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("message = " + str);
            ss.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
}