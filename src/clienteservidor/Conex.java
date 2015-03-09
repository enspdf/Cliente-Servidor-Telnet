package clienteservidor;

import java.net.*;
import java.io.*;

public class Conex{
    final int PUERTO=5000;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    String mensajeRecibido;
    
    public void initServer()
    {
        BufferedReader entrada;
        try {
            sc = new ServerSocket(PUERTO);
            so= new Socket();
            System.out.println("Esperando conexión");
            so=sc.accept();
            
            System.out.println("Un cliente se ha conectado");
            entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
            salida = new DataOutputStream(so.getOutputStream());
            System.out.println("Confirmando conexion al cliente ...");
            salida.writeUTF("Conexion exitosa... envia un mensaje");
            
            mensajeRecibido = entrada.readLine();
            System.out.println(mensajeRecibido);
            salida.writeUTF("Se recibio tu mensaje. terminando conexion ...");
            salida.writeUTF("Gracias por conectarte! BYE.");
            System.out.println("Cerrando conexion");
            sc.close();
        } catch (Exception e) {
            System.out.println("Error:" +e.getMessage());
        }
    }
}