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
    public static ChangeCity changeCity;
    public static ChangeAircraft changeAircraft;
    public static RemoveCity removeCity;
    public static RemoveAircraft removeAircraft;
    public static String[] city;
    public static ChangeFlight changeFlight;
    public static RemoveFlight removeFlight;
    ArrayList<Cities> cities;
    ArrayList<Aircrafts> aircrafts;
    ArrayList<Flights> flights;

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

        changeCity = new ChangeCity(this);
        changeCity.setVisible(false);
        add(changeCity);

        changeAircraft = new ChangeAircraft(this);
        changeAircraft.setVisible(false);
        add(changeAircraft);

        removeCity = new RemoveCity(this);
        removeCity.setVisible(false);
        add(removeCity);

        removeAircraft = new RemoveAircraft(this);
        removeAircraft.setVisible(false);
        add(removeAircraft);

        changeFlight = new ChangeFlight(this);
        changeFlight.setVisible(false);
        add(changeFlight);

        removeFlight = new RemoveFlight(this);
        removeFlight.setVisible(false);
        add(removeFlight);
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
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
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
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
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
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
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
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
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
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
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
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
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
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
    }

    public void showChangeCitiesPage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
        changeCity.setVisible(true);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
    }

    public void showChangeAircraftsPage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
        changeCity.setVisible(false);
        changeAircraft.setVisible(true);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
    }

    public void showRemoveCitiesPage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(true);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
    }

    public void showRemoveAircraftsPage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(true);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
    }

    public void showChangeFlightsPage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(true);
        removeFlight.setVisible(false);
    }

    public void removeFlightsPage(){
        createAircraft.setVisible(false);
        removePage.setVisible(false);
        changePage.setVisible(false);
        createPage.setVisible(false);
        mainMenu.setVisible(false);
        serverConnection.setVisible(false);
        createCity.setVisible(false);
        createFlight.setVisible(false);
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeCity.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(true);
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
        changeCity.setVisible(false);
        changeAircraft.setVisible(false);
        removeAircraft.setVisible(false);
        changeFlight.setVisible(false);
        removeFlight.setVisible(false);
    }


    public static boolean connectToServer (String ip, int port){

        boolean check = false;
        try{
            socket = new Socket(ip,port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
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

    public ArrayList<Cities> readCities(){
        cities = null;
        try{
            cities = (ArrayList<Cities>) objectInputStream.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }
        return cities;
    }

    public ArrayList<Aircrafts> readAircrafts(){
        aircrafts = null;
        try{
            aircrafts = (ArrayList<Aircrafts>) objectInputStream.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }
        return aircrafts;
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


    public int fromIndexToId(int departureCityIdNumber){
        int id = Math.toIntExact(cities.get(departureCityIdNumber).id);
        return id;
    }

    public Long fromIndexToIdChange(int departureCityIdNumber){
        Long id = cities.get(departureCityIdNumber).id;
        return id;
    }

    public int fromIndexToIdAirCraft(int airCraftId){
        int id = Math.toIntExact(aircrafts.get(airCraftId).id);
        return id;
    }

    public Long fromIndexToIdAirCraftChange(int airCraftId){
        Long id = aircrafts.get(airCraftId).id;
        return id;
    }

}
