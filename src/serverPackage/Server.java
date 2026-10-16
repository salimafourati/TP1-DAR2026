package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //1-Créer le socket d'écoute sur le port 1234
        ServerSocket socketServeur = new ServerSocket(1234);
        System.out.println("je suis un serveur en attente de la connexion");
        //2-Attendre puis accepter le connexion d'un client
        Socket socket = socketServeur.accept();
        System.out.println("Un client est connecté");
        //3-Fermer les sockets
        socket.close();
        socketServeur.close();
    }
}
