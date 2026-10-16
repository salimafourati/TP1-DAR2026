package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //1-Client attend la connexion au serveur
        System.out.println("Je suis un client pas encore connecté");
        //2-crée un socket client et tente de se connecter au serveur.
        Socket socket = new Socket("192.168.100.235", 1234);
        //3-Le client et le serveur ont établi une connexion TCP.
        System.out.println("je suis un client connecté");
        //4-Fermeture de socket
        socket.close();
    }
}
