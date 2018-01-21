import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Вадим on 20.01.2018.
 */
public class Client {
    private static String HOST;
    private static Integer PORT;

    public static void main(String[] args) {

        HOST = "localhost";
        PORT = 12345;

        try(Socket socket = new Socket(HOST, PORT)){
            System.out.println("Connected to the Server!");

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject("132, 84, 541, 21, -684, 298, 100, 5416");

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String result = (String) inputStream.readObject();

            System.out.println("Result: " + result);

        } catch (ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
    }
}
