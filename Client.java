import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Client
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Client exemple v1.0");
            Socket s = new Socket("localhost", 7777);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello server!");
            dout.flush();
            dout.close();
            s.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
}