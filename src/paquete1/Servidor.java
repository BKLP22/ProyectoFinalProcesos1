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
        Servidores s1 = new Servidores();
        s1.iniciarConexion();
    }
}

