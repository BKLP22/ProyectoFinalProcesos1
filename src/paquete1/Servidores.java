package paquete1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidores
{
    ServerSocket servidor=null;
    Socket sc=null;
    DataInputStream in;
    DataOutputStream out;
    final int PUERTO=5000;
    Scanner sc1 = new Scanner(System.in);

    public void iniciarConexion()
    {
        try
        {
            servidor=new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            while(true)
            {
                sc=servidor.accept();
                System.out.println("Cliente conectado");
                in=new DataInputStream(sc.getInputStream());//recibir mensajes
                out=new DataOutputStream(sc.getOutputStream());//enviar mensajes
                enviarMensaje();
                recibirMensaje();
                sc.close();//cerramos el servidor
                out.flush();
                System.out.println("Cliente desconectado");
            }
        }catch(IOException ex)
        {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
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
