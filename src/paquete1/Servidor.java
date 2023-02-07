package paquete1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor
{
    public static void main(String[] args)
    {
        ServerSocket servidor=null;
        Socket sc=null;
        final int PUERTO=5000;//
        DataInputStream in;
        DataOutputStream out;
        Scanner sc1 = new Scanner(System.in);
        String respuesta;
        boolean fin = true  ;
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
                while(fin == true){

                    String mensaje=in.readUTF();
                    System.out.println(mensaje);
                    System.out.println("escribee.....");
                    respuesta= sc1.nextLine();
                    out.writeUTF(respuesta);
                    if(mensaje.equals("1")){
                        fin = false;
                    }else{
                        fin = true;
                    }
                }
                String mensaje2=in.readUTF();
                System.out.println(mensaje2);

                sc.close();//cerramos el servidor

                System.out.println("Cliente desconectado");
            }
        }catch(IOException ex)
        {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

