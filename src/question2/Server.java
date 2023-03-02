package question2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        int wordsStartWithVowel=wordsStartWithVowelCount(s);
        System.out.println("Number of words start with vowel: "+wordsStartWithVowel);

        int articleCount=articleCount(s);
        System.out.println("Number of articles : "+articleCount);


    }

    private static int wordsStartWithVowelCount(String s) {

        try {
            Socket socket = new Socket("localhost", 9998);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(s);

            System.out.println("Client1 connected....");

            int count = in.readInt();

            return count;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    private static int articleCount(String s) {
        try {
            Socket socket = new Socket("localhost", 9999);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(s);

            System.out.println("Client2 connectedt....");

            int count = in.readInt();
            return count;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
