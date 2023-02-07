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
        Clientes cliente1 = new Clientes("127.0.0.1",5000);

        cliente1.iniciarChat();
    }
}
