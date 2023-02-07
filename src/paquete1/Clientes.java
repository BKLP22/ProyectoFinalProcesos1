package paquete1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clientes
{
    String HOST;
    int puerto;
    public Clientes(String HOST, int puerto) {
        this.HOST = HOST;
        this.puerto = puerto;
    }


    DataInputStream in;
    DataOutputStream out;
    Scanner sc1 = new Scanner(System.in);




    public void iniciarChat()
    {
        try {
            Socket sc = new Socket(HOST, puerto);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            System.out.println("Chat iniciado");
            System.out.println(recibirMensaje());
            enviarMensaje();
            enviarMensaje();
        }catch (IOException ex)
        {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public String recibirMensaje()
    {
        String mensaje1="No hay mensaje";
        try{
            mensaje1=in.readUTF();
        }catch (IOException ex)
        {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
        }
        return mensaje1;
    }

    public String enviarMensaje()
    {
        String mensaje2=sc1.nextLine();
        try{
            out.writeUTF(mensaje2);
        }catch (IOException ex)
        {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
        }
        return mensaje2;
    }
}
