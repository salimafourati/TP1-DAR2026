package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) throws IOException {
        // 1 - Se connecter au serveur
        Socket socket = new Socket("localhost", 1234);
        Scanner sc = new Scanner(System.in);
        System.out.println("Client connecte au serveur.");
        // 2 - Creer les flux de communication
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        int x;
        // 3 - Saisir et envoyer plusieurs entiers
        do {
            System.out.print("Entrez un entier (0 pour arreter) : ");
            x = sc.nextInt();
            // 4 - Envoyer l'entier au serveur
            dos.writeInt(x);
            dos.flush();
            // 5 - Recevoir le resultat si x est different de 0
            if (x != 0) {
                int resultat = dis.readInt();
                System.out.println("Resultat recu : " + resultat);
            }
        } while (x != 0);
        // 6 - Fermer les flux et la socket
        dis.close();
        dos.close();
        socket.close();
        sc.close();
    }
}
