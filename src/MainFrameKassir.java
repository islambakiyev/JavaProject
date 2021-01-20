import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MainFrameKassir extends JFrame {
    public static Socket socket;
    public static ObjectOutputStream objectOutputStream;
    public static ObjectInputStream objectInputStream;
    public static PackageData packageData;
    public static MainMenuKassir mainMenuKassir;
    public static CreateTicket createTicket;
    public static ChangeTicket changeTicket;
    public static RemoveTicket removeTicket;
    ArrayList<Flights> flights;
    ArrayList<Tickets> tickets;


    public MainFrameKassir() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Приложение кассира");
        setSize(700,700);

        socket = new Socket("127.0.0.1",204);
        System.out.println("Соединение установлено");
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());

        mainMenuKassir = new MainMenuKassir(this);
        mainMenuKassir.setVisible(true);
        add(mainMenuKassir);

        createTicket = new CreateTicket(this);
        createTicket.setVisible(false);
        add(createTicket);

        changeTicket = new ChangeTicket(this);
        changeTicket.setVisible(false);
        add(changeTicket);

        removeTicket = new RemoveTicket(this);
        removeTicket.setVisible(false);
        add(removeTicket);

    }

    public void showMainMenuKassir(){
        mainMenuKassir.setVisible(true);
        createTicket.setVisible(false);
        changeTicket.setVisible(false);
        removeTicket.setVisible(false);
    }

    public void showCreateTicket(){
        mainMenuKassir.setVisible(false);
        createTicket.setVisible(true);
        changeTicket.setVisible(false);
        removeTicket.setVisible(false);
    }

    public void showChangeTicket(){
        mainMenuKassir.setVisible(false);
        createTicket.setVisible(false);
        changeTicket.setVisible(true);
        removeTicket.setVisible(false);
    }

    public void showRemoveTicket(){
        mainMenuKassir.setVisible(false);
        createTicket.setVisible(false);
        changeTicket.setVisible(false);
        removeTicket.setVisible(true);
    }

    public static void sendPackage (PackageData packageData){
        try{
            objectOutputStream.writeObject(packageData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Flights> readFlights(){
        flights = null;
        try{
            flights = (ArrayList<Flights>) objectInputStream.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }
        return flights;
    }

    public ArrayList<Tickets> readTickets(){
        tickets = null;
        try{
            tickets = (ArrayList<Tickets>) objectInputStream.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }
        return tickets;
    }

    public int fromIndexToIdFlight(int flightId){
        int id = Math.toIntExact(flights.get(flightId).id);
        return id;
    }

    public Long fromIndexToIdChange(Long passengerId){
        Long id = tickets.get(Math.toIntExact(passengerId)).id;
        return id;
    }
}
