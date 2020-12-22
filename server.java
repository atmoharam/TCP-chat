import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server {
    Server()
    {
        try (ServerSocket Server = new ServerSocket(22000))
        {
            //listen
               Socket client =Server.accept();
               DataInputStream clientReadSource= new DataInputStream(client.getInputStream()) ;
               DataOutputStream clientWriteSource = new DataOutputStream(client.getOutputStream());
 
               clientWriteSource.writeUTF("You are connected but not for long");
               clientWriteSource.writeUTF("you can ask me for once");
               String Str =clientReadSource.readUTF();
               System.out.println("Client said: "+Str);
               clientWriteSource.writeUTF("We have no services right now, goodbye");
               clientWriteSource.close();
               clientReadSource.close();
               client.close();
 
        }
        catch (IOException e) {
            e.printStackTrace();
        }
 
 
    }
 
}
