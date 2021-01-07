import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public static Socket socket;
    public static ObjectOutputStream objectOutputStream;
    public static ObjectInputStream objectInputStream;
    public static PackageData packageData;
    public static ServerConnection serverConnection;
    public static MainMenu mainMenu;
    public static CreatePage createPage;
    public static ChangePage changePage;
    public static RemovePage removePage;
    public static CreateAircraft createAircraft;
    public static CreateCity createCity;
    public static CreateFlight createFlight;
    public static String[] city;

    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Клиент-серверное приложение");
        setSize(700,700);

        serverConnection = new ServerConnection(this);
        serverConnection.setVisible(true);
        add(serverConnection);

        mainMenu = new MainMenu(this);
        mainMenu.setVisible(false);
        add(mainMenu);

        createPage = new CreatePage(this);
        createPage.setVisible(false);
        add(createPage);

        changePage = new ChangePage(this);
        changePage.setVisible(false);
        add(changePage);

        removePage = new RemovePage(this);
        removePage.setVisible(false);
        add(removePage);

        createAircraft = new CreateAircraft(this);
        createAircraft.setVisible(false);
        add(createAircraft);

        createCity = new CreateCity(this);
        createCity.setVisible(false);
        add(createCity);

        createFlight = new CreateFlight(this);
        createFlight.setVisible(false);
        add(createFlight);
    }

    public void showMainMenu(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(true);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
    }

    public void showCreatePage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(true);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
    }

    public void showChangePage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(true);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
    }

    public void showRemovePage(){
        createAircraft.setVisible(false);
        removePage.setVisible(true);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
    }

    public void showCreateAircraftPage(){
        createAircraft.setVisible(true);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
    }

    public void showCreateCityPage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(true);
        createFlight.setVisible(false);
    }

    public void showCreateFlightPage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(true);
    }

    public void backToCreatePageMenu(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(true);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
    }


    public static boolean connectToServer (String ip, int port){

        boolean check = false;
        try{
            socket = new Socket(ip,port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            check = true;

        }catch (Exception e){
            e.printStackTrace();
            check = false;
        }
        return check;

    }


    public static void sendPackage (PackageData packageData){
        try{
            objectOutputStream.writeObject(packageData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readCities(){
        try{
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            ArrayList<Cities> cities = (ArrayList<Cities>) objectInputStream.readObject();
            city = new String[cities.size()];

            for(int i = 0; i<cities.size();i++){
                city[i] = cities.get(i).getName();

            }

            createFlight.city = city;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createComboBox(){
        JComboBox departureCityIdField = new JComboBox(city);
        departureCityIdField.setLocation(250,170);
        departureCityIdField.setSize(200,30);
        add(departureCityIdField);
    }
}
