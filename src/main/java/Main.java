import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5050, 10);
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept(); // ожидаем подключения к этому сокету и принимает его
                new ServerMessage(socket);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}