import java.io.*;
import java.net.Socket;

public class ServerMessage extends Thread{
    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private PrintWriter out; // поток записи в сокет

    public ServerMessage(Socket socket) throws IOException {
        this.socket = socket;
    }


    @Override
    public void run() {
        try{
        in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //принимаем сообщения
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true); //отправляем сообщения
            while (true) {
                String mes = in.readLine(); //ждём пока клиент напишет
                if (mes.equals("Bye."))
                    break;
                    out.println(mes);
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

