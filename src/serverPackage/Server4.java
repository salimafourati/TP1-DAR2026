package serverPackage;
import java.io.*;
import java.net.*;

public class Server4 {
    public static void main(String[] args) throws IOException{
        // 1 - Recuperer l'adresse IP du serveur
        InetAddress adresseIP = InetAddress.getByName("192.168.1.7");
        int port = 1234;
        // 2 - Creer le serveur et definir son adresse
        ServerSocket serveur = new ServerSocket();
        serveur.bind(new InetSocketAddress(adresseIP, port));
        System.out.println("Serveur en attente sur " + adresseIP.getHostAddress() + ":" + port);
        // 3 - Accepter la connexion du client
        Socket socket = serveur.accept();
        System.out.println("Client connecte : " + socket.getInetAddress().getHostAddress());
        // 4 - Creer les flux de communication
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // 5 - Traiter les operations demandees
        while (true) {
            int choix = dis.readInt();
            if (choix == 0) {
                break;
            }
            double a = dis.readDouble();
            double b = dis.readDouble();
            double resultat = 0;
            boolean valide = true;
            switch (choix) {
                case 1:
                    resultat = a + b;
                    break;
                case 2:
                    resultat = a - b;
                    break;
                case 3:
                    resultat = a * b;
                    break;
                case 4:
                    if (b == 0) {
                        valide = false;
                    } else {
                        resultat = a / b;
                    }
                    break;
                default:
                    valide = false;
            }
            // 6 - Envoyer le resultat au client
            dos.writeBoolean(valide);
            if (valide) {
                dos.writeDouble(resultat);
            }
            dos.flush();
        }
        dis.close();
        dos.close();
        socket.close();
        serveur.close();
        System.out.println("Communication terminee.");
        System.out.println("Serveur ferme.");
        }
}
