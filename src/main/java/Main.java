import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static int PORT = 5050;
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            java.util.logging.Logger.getGlobal().info("Server started");
            while (true) {
                Socket socket = serverSocket.accept(); // ожидаем подключения к этому сокету и принимает его
                new ServerMessage(socket).start();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}