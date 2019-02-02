package Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiThreadServer extends Application {

    private TextArea ta = new TextArea();
    private int clientNo = 0;

    public void start(Stage primaryStage){
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("MultiThreadServer");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread( () -> {
            try{
                ServerSocket serverSocket = new ServerSocket(8000);
                ta.appendText("MultiThreadServer started at " + new Date() + "\n");

                while (true) {
                    Socket socket = serverSocket.accept();
                    clientNo ++;

                    Platform.runLater( () -> {
                        ta.appendText("Starting thread for client " + clientNo +
                                " at " + new Date() + "\n");

                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client " + clientNo + "'s host name is "
                                + inetAddress.getHostName() + "\n");
                        ta.appendText("Client " + clientNo + "'s IP Address is "
                                + inetAddress.getHostAddress() + "\n");
                    });
                    new Thread(new HandleClient(socket)).start();
                }
            }catch (IOException ex){
                System.err.println(ex);
            }
        }).start();
    }

    class HandleClient implements Runnable {
        private Socket socket;

        public HandleClient(Socket socket){
            this.socket = socket;
        }

        public void run(){
            try {
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(
                        socket.getOutputStream());

                while (true){
                    double radius = inputFromClient.readDouble();

                    double area = Math.PI * radius* radius;
                    outputStream.writeDouble(area);

                    Platform.runLater( () -> {
                        ta.appendText("radius received from client: " +
                                radius + '\n');
                        ta.appendText("Area found: " + area + '\n');
                    });
                }

            }catch( IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
