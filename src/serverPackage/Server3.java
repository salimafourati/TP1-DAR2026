package serverPackage;

import java.io.*;
import java.net.*;

public class Server3 {
    public static void main(String[] args)throws IOException{
        //1-Créer le socket d'écoute sur le port 1234
        ServerSocket socketServeur = new ServerSocket(1234);
        System.out.println("je suis un serveur en attente de la connexion");
        //2-Attendre puis accepter le connexion d'un client
        Socket socket = socketServeur.accept();
        System.out.println("Un client est connecté");
        // 3 - Creer les flux de communication
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        //4-Recevoir plusieurs entiers
        while(true){
            int nb = dis.readInt();
            System.out.println("Le serveur a reçu le nombre : " + nb);
            //6-Si nb=0 on arrete la communication
            if(nb==0){
                System.out.println("le client demande l'arret de communication");
                break;
            }
            //7-Calcul de resultat
            int x=nb*5;
            System.out.println("Calcul du serveur : " + nb + " * 5 = " + x);
            //8-renvoie de resultat au client
            dos.writeInt(x);
            dos.flush();
            System.out.println("Le résultat a été envoyé au client : " + x);
        }
            //9-Fermeture des sockets
        dis.close();
        dos.close();
        socket.close();
        socketServeur.close();

    }
}
