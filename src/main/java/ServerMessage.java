import java.io.*;
import java.net.Socket;

public class ServerMessage extends Thread{
    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет

    public ServerMessage(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //принимаем сообщения
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //отправляем сообщения
        start(); // вызываем метод run()
    }

    public void run() {
        try {
            while (true) {
                String mes = in.readLine(); //ждём пока клиент напишет
                if (mes.equals("Bye."))
                    break;
                    out.write(mes + "\n"); //отвечаем клиенту
                    out.flush(); //выталкиваем все из буфера
                }
        }catch (IOException exp) {
            System.out.println(exp.getMessage());
        }finally {
            try {
                in.close();
                out.close();
                socket.close();
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

