import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class Client
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Client exemple v1.1");
            Socket s = new Socket("localhost", 7777);
            DataInputStream  din  = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop"))
            {
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                str2 = din.readUTF();
                System.out.println("Serveur dit: " + str2);
            }
            dout.close();
            s.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
}