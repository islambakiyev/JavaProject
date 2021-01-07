import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Server {

    static Connection connection;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("useUnicode","true");
        properties.setProperty("password","");
        properties.setProperty("characterEncoding","UTF-8");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aviata?serverTimezone=UTC",properties);
        System.out.println("Соединение с базой данных установлено");

        try{
            ServerSocket server = new ServerSocket(203);
            System.out.println("Соединение с сервером установлено");

            while(true){
                Socket socket = server.accept();
                ClientHandler ch = new ClientHandler(connection,socket);
                ch.start();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
