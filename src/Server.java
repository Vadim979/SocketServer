import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Вадим on 20.01.2018.
 */
public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        ServerSocket serverSocket = new ServerSocket(12345);
        while (true){
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();

            System.out.println("Client has been connected!");

            System.out.println("Reading input stream...");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            String inputString = (String)objectInputStream.readObject();

            System.out.println("Input: " + inputString);

            MaxValue maxValue = new MaxValue(inputString);
            String outputString = maxValue.getResult();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(outputString);

            System.out.println("Output: " + outputString);
        }
    }
}
