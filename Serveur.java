import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class Serveur
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Serveur exemple v1.1");
            ServerSocket ss = new ServerSocket(7777);
            Socket s = ss.accept();
            DataInputStream  din  = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String str = "", str2 = "";
            while (!str.equals("stop"))
            {
                str = din.readUTF();
                System.out.println("Client dit: " + str);
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }
            din.close();
            s.close();
            ss.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
}