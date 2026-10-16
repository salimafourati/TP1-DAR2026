package clientPackage;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args)throws IOException{
        //1-Client attend la connexion au serveur
        System.out.println("je suis un client en attente de connexion");
        //2-Client se connecte au serveur
        Socket socket = new Socket("localhost", 1234);
        System.out.println("je suis un client connecté");
        //3-demander d'entrer un entier
        Scanner sc=new Scanner(System.in);
        System.out.print("entrez un entier");
        int x=sc.nextInt();
        //4-Envoyer l'entier au serveur
        OutputStream os=socket.getOutputStream();
        DataOutputStream dos=new DataOutputStream(os);
        dos.writeInt(x);
        System.out.println("Nombre envoyé au serveur"+x);
        //5-Recevoir le resultat
        InputStream is=socket.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        int r=dis.readInt();
        System.out.println("resultat reçu du serveur"+r);
        //6-Fermeture du socket
        dis.close();
        dos.close();
        socket.close();
        sc.close();
            }
        }


