import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    Connection connection;
    Socket socket;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    public ClientHandler(Connection connection, Socket socket) throws IOException {
        this.connection = connection;
        this.socket = socket;
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        PackageData packageData;
        try{

            while((packageData = (PackageData) objectInputStream.readObject())!=null) {
                if (packageData.operationType.equals("ADD AIRCRAFT")) {
                    addAirCraftsToDb(packageData.getAircraft());
                }
                if(packageData.operationType.equals("ADD CITY")){
                    addCitiesToDb(packageData.getCity());
                }
                if(packageData.operationType.equals("ADD FLIGHT")){
                    addFlightsToDb(packageData.getFlight());
                }
                if (packageData.operationType.equals("cities")){
                    objectOutputStream.writeObject(getCitiesFromDB());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addAirCraftsToDb(Aircrafts aircraft){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(id, name, model, business_class_capacity, econom_class_capacity) VALUES (null,\""+aircraft.getName()+"\",\"" + aircraft.getModel()+"\",\"" + aircraft.getBusinessClassCapacity() + "\",\"" + aircraft.getEconomClassCapacity() + "\")");
            st.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addCitiesToDb(Cities city){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO cities(id,name,country,short_name)VALUES (null,\""+city.getName()+"\",\"" + city.getCountry()+"\",\"" + city.getShortName() + "\")");
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addFlightsToDb(Flights flight){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO flights(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price) VALUES (null,\""+flight.getAirCraftId()+"\",\"" + flight.getDepartureCityId()+"\",\"" + flight.getArrivalCityId() +"\",\"" + flight.getDepartureTime() + "\",\"" + flight.getEconomPlacePrice() + "\",\"" + flight.getBusinessPlacePrice() + "\")");
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Cities> getCitiesFromDB() throws SQLException {
        ArrayList<Cities> cities = new ArrayList<Cities>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cities");
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String country = rs.getString("country");
            String shortName = rs.getString("short_name");
            cities.add(new Cities(id,name,country,shortName));
        }

        return cities;
    }

    public void addTicketsToDb(){

    }
}
