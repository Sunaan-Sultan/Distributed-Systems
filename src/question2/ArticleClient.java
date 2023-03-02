package question2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ArticleClient {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String s = in.readUTF();

        out.writeInt(count(s));

    }

    private static int count(String s) {
        Map<String,Integer> map = new HashMap<>();
        s=s.toLowerCase();
        String[] words = s.split(" ");

        for (String word : words) {


                if(map.containsKey(word)){
                    map.put(word,map.get(word)+1);
                }else{
                    map.put(word,1);
                }

        }


        int count=0;

        for (String x : map.keySet()) {
            if(x.equals("a") ||
                    x.equals("an") ||
                    x.equals("the")){
                count+=map.get(x);
            }
        }

        return count;
    }
}
