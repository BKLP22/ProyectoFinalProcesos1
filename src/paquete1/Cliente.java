package paquete1;


import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente {

    public static void main(String[] args){

        //Mi máquina
        final String HOST="127.0.0.1";
        //MISMO PUERTO QUE EN EL SERVIDOR
        final int PUERTO=5000;

        DataInputStream in;
        DataOutputStream out;
        Scanner sc1 = new Scanner(System.in);
        String mensaje1;
        boolean fin = true  ;

        try{
            Socket sc=new Socket(HOST,PUERTO);
            in=new DataInputStream(sc.getInputStream());
            out=new DataOutputStream(sc.getOutputStream());
            System.out.println("escriba el mensaje...");

            while(fin == true){
                mensaje1=sc1.nextLine();
                out.writeUTF(mensaje1);
                String mensaje=in.readUTF();
                System.out.println(mensaje);
                System.out.println("escriba el mensaje...");
                mensaje1=sc1.nextLine();
                out.writeUTF(mensaje1);
                if(mensaje.equals("1")){
                    fin = false;
                }else{
                    fin = true;
                }
            }



            sc.close();

        }catch (IOException ex)
        {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
