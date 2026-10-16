package serverPackage;
import java.io.*;
import java.net.*;

public class Server2 {
    public static void main(String[] args) throws IOException{
        //1-Créer le socket d'écoute sur le port 1234
        ServerSocket socketServeur = new ServerSocket(1234);
        System.out.println("je suis un serveur en attente de la connexion");
        //2-Attendre puis accepter le connexion d'un client
        Socket socket = socketServeur.accept();
        System.out.println("Un client est connecté");
        //3-recevoir le nombre envoyé par le client
        InputStream is= socket.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        int nb=dis.readInt();
        System.out.println("le serveur a reçu le nombre:"+nb);
        //4-Calculer x*5
        int x=nb*5;
        System.out.println("Calcul du serveur"+nb+"*5="+x);
        //5-Envoyer le resultat au client
        OutputStream os=socket.getOutputStream();
        DataOutputStream dos=new DataOutputStream(os);
        dos.writeInt(x);
        System.out.println("le resultat a ete envoye au client"+x);
        //6-Fermeture de socket
        dis.close();
        dos.close();
        socketServeur.close();
        socket.close();

    }
}
