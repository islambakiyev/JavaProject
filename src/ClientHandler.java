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
        try {

            while ((packageData = (PackageData) objectInputStream.readObject()) != null) {
                if (packageData.operationType.equals("ADD AIRCRAFT")) {
                    addAirCraftsToDb(packageData.getAircraft());
                }
                if (packageData.operationType.equals("ADD CITY")) {
                    addCitiesToDb(packageData.getCity());
                }
                if (packageData.operationType.equals("ADD FLIGHT")) {
                    addFlightsToDb(packageData.getFlight());
                }
                if (packageData.operationType.equals("cities")) {
                    objectOutputStream.writeObject(getCitiesFromDB());
                }
                if (packageData.operationType.equals("aircrafts")) {
                    objectOutputStream.writeObject(getAircraftsFromDB());
                }
                if (packageData.operationType.equals("arrival cities")) {
                    objectOutputStream.writeObject(getCitiesFromDB());
                }
                if (packageData.operationType.equals("change cities")) {
                    objectOutputStream.writeObject(getCitiesFromDB());
                }
                if (packageData.operationType.equals("CHANGE CITY")) {
                    updateCitiesInDb(packageData.getCity());
                }
                if (packageData.operationType.equals("aircrafts list")) {
                    objectOutputStream.writeObject(getAircraftsFromDB());
                }
                if (packageData.operationType.equals("CHANGE AIRCRAFT")) {
                    updateAircraftsInDb(packageData.getAircraft());
                }
                if (packageData.operationType.equals("remove cities")) {
                    objectOutputStream.writeObject(getCitiesFromDB());
                }
                if (packageData.operationType.equals("REMOVE CITY")) {
                    deleteCityFromDb(packageData.getCity());
                }
                if (packageData.operationType.equals("REMOVE AIRCRAFTS PAGE")) {
                    objectOutputStream.writeObject(getAircraftsFromDB());
                }
                if (packageData.operationType.equals("REMOVE AIRCRAFT")) {
                    deleteAircraftFromDb(packageData.getAircraft());
                }
                if (packageData.operationType.equals("flights list")) {
                    objectOutputStream.writeObject(getFlightsFromDB());
                }
                if (packageData.operationType.equals("CHANGE FLIGHT")) {
                    updateFlightsInDb(packageData.getFlight());
                }
                if (packageData.operationType.equals("REMOVE FLIGHT")) {
                    objectOutputStream.writeObject(getFlightsFromDB());
                }
                if (packageData.operationType.equals("DELETE FLIGHT")) {
                    deleteFlightFromDB(packageData.getFlight());
                }
                if (packageData.operationType.equals("get all flights")) {
                    objectOutputStream.writeObject(getFlightsFromDB());
                }
                if (packageData.operationType.equals("CREATE TICKET")) {
                    addTicketsToDb(packageData.getTicket());
                }
                if (packageData.operationType.equals("get all passengers")) {
                    objectOutputStream.writeObject(getTicketsFromDB());
                }
                if (packageData.operationType.equals("get all flights for change")) {
                    objectOutputStream.writeObject(getFlightsFromDB());
                }
                if (packageData.operationType.equals("CHANGE TICKET")) {
                    updateTicketInDB(packageData.getTicket());
                }
                if (packageData.operationType.equals("DELETE TICKET")) {
                    deleteTicketFromDB(packageData.getTicket());
                }
                if (packageData.operationType.equals("get all passengers for delete")) {
                    objectOutputStream.writeObject(getTicketsFromDB());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAirCraftsToDb(Aircrafts aircraft) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(id, name, model, business_class_capacity, econom_class_capacity) VALUES (null,\"" + aircraft.getName() + "\",\"" + aircraft.getModel() + "\",\"" + aircraft.getBusinessClassCapacity() + "\",\"" + aircraft.getEconomClassCapacity() + "\")");
            st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCitiesToDb(Cities city) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO cities(id,name,country,short_name)VALUES (null,\"" + city.getName() + "\",\"" + city.getCountry() + "\",\"" + city.getShortName() + "\")");
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addFlightsToDb(Flights flight) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO flights(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price) VALUES (null,\"" + flight.getAirCraftId() + "\",\"" + flight.getDepartureCityId() + "\",\"" + flight.getArrivalCityId() + "\",\"" + flight.getDepartureTime() + "\",\"" + flight.getEconomPlacePrice() + "\",\"" + flight.getBusinessPlacePrice() + "\")");
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addTicketsToDb(Tickets ticket) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tickets(id,flight_id,name,surname,passport_number,ticket_type) VALUES (null,\"" + ticket.getFlight_id()+"\",\""+ticket.getName()+"\",\""+ticket.getSurname()+"\",\""+ticket.getPassport_number()+"\",\""+ticket.getTicket_type()+"\")");
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateCitiesInDb(Cities cities) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE cities set name = ?, country = ?, short_name = ? where id = ?");
            st.setString(1, cities.getName());
            st.setString(2, cities.getCountry());
            st.setString(3, cities.getShortName());
            st.setLong(4, cities.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFlightsInDb(Flights flights){
        int id = 0;
        int departureCity = 0;
        int arrivalCity = 0;

        try{
            PreparedStatement takeAircraftId = connection.prepareStatement("SELECT id FROM aircrafts where name = ?");
            takeAircraftId.setString(1,flights.getAircraft());
            ResultSet resultSet = takeAircraftId.executeQuery();
            while(resultSet.next()){
            id = resultSet.getInt("id");}


            PreparedStatement takeDepartureCity = connection.prepareStatement("SELECT id FROM cities where name = ?");
            takeDepartureCity.setString(1, flights.getCity());
            ResultSet resultSet1 = takeDepartureCity.executeQuery();
            while(resultSet1.next()){
            departureCity = resultSet1.getInt("id");}

            PreparedStatement takeArrivalCity = connection.prepareStatement("SELECT id FROM cities where name = ?");
            takeArrivalCity.setString(1, flights.getArrivalCity());
            ResultSet resultSet2 = takeArrivalCity.executeQuery();
            while(resultSet2.next()){
            arrivalCity = resultSet2.getInt("id");}


            PreparedStatement updateData = connection.prepareStatement("UPDATE flights set aircraft_id = ?, departure_city_id = ?, arrival_city_id = ?, departure_time = ?, econom_place_price = ?, business_place_price = ? where id = ?");
            updateData.setInt(1,id);
            updateData.setInt(2,departureCity);
            updateData.setInt(3,arrivalCity);
            updateData.setString(4,flights.getDepartureTime());
            updateData.setInt(5,flights.getEconomPlacePrice());
            updateData.setInt(6,flights.getBusinessPlacePrice());
            updateData.setLong(7,flights.getId());
            updateData.executeUpdate();
            updateData.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateAircraftsInDb(Aircrafts aircrafts) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE aircrafts set name = ?, model = ?, business_class_capacity = ?, econom_class_capacity = ? where id = ?");
            st.setString(1, aircrafts.getName());
            st.setString(2, aircrafts.getModel());
            st.setInt(3, aircrafts.getBusinessClassCapacity());
            st.setInt(4, aircrafts.getEconomClassCapacity());
            st.setLong(5, aircrafts.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTicketInDB(Tickets tickets){
        try {
          PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tickets set flight_id = ?, name = ?, surname = ?, passport_number = ?, ticket_type = ? where id = ?");
          preparedStatement.setInt(1,tickets.getFlight_id());
          preparedStatement.setString(2,tickets.getName());
          preparedStatement.setString(3,tickets.getSurname());
          preparedStatement.setString(4, tickets.getPassport_number());
          preparedStatement.setString(5, tickets.getTicket_type());
          preparedStatement.setLong(6,tickets.getId());
          preparedStatement.executeUpdate();
          preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Cities> getCitiesFromDB() throws SQLException {
        ArrayList<Cities> cities = new ArrayList<Cities>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cities");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String country = rs.getString("country");
            String shortName = rs.getString("short_name");
            cities.add(new Cities(id, name, country, shortName));
        }

        return cities;
    }


    public ArrayList<Aircrafts> getAircraftsFromDB() throws SQLException {
        ArrayList<Aircrafts> aircrafts = new ArrayList<Aircrafts>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM aircrafts");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String model = rs.getString("model");
            int businessClassCapacity = rs.getInt("business_class_capacity");
            int economClassCapacity = rs.getInt("econom_class_capacity");
            aircrafts.add(new Aircrafts(id, name, model, businessClassCapacity, economClassCapacity));
        }

        return aircrafts;
    }

    public ArrayList<Tickets> getTicketsFromDB() throws SQLException {
        ArrayList<Tickets> tickets = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tickets");
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            Long id = resultSet.getLong("id");
            int flightId = resultSet.getInt("flight_id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String passport = resultSet.getString("passport_number");
            String ticketType = resultSet.getString("ticket_type");
            tickets.add(new Tickets(id,flightId,name,surname,passport,ticketType));
        }
        return tickets;
    }

    public ArrayList<Flights> getFlightsFromDB() throws SQLException {
        ArrayList<Flights> flights = new ArrayList<>();
        String city = "";
        String aircraft = "";
        String arrivalCity = "";
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM flights");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Long id = rs.getLong("id");
            int aircraftId = rs.getInt("aircraft_id");
            int departureCityId = rs.getInt("departure_city_id");
            int arrivalCityId = rs.getInt("arrival_city_id");
            String departureTime = rs.getString("departure_time");
            int economPlacePrice = rs.getInt("econom_place_price");
            int businessPlacePrice = rs.getInt("business_place_price");

            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT name FROM cities where id = ?");
            preparedStatement1.setInt(1,departureCityId);
            ResultSet takeCitiesName = preparedStatement1.executeQuery();

            while (takeCitiesName.next()) {
                city = takeCitiesName.getString("name");
            }

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT name FROM aircrafts where id = ?");
            preparedStatement2.setInt(1,aircraftId);
            ResultSet takeAircraftName = preparedStatement2.executeQuery();

            while (takeAircraftName.next()){
                aircraft = takeAircraftName.getString("name");
            }

            PreparedStatement preparedStatement3 = connection.prepareStatement("SELECT name FROM cities where id = ?");
            preparedStatement3.setInt(1,arrivalCityId);
            ResultSet takeArrivalCity = preparedStatement3.executeQuery();

            while (takeArrivalCity.next()){
                arrivalCity = takeArrivalCity.getString("name");
            }

            flights.add(new Flights(id, aircraft, arrivalCity, departureTime, economPlacePrice, businessPlacePrice, city));

        }
        return flights;
    }

    public void deleteCityFromDb(Cities cities) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cities where id = ?");
            preparedStatement.setLong(1, cities.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTicketFromDB(Tickets ticket){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tickets where id = ?");
            preparedStatement.setLong(1,ticket.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteFlightFromDB(Flights flights){
        try{
           PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM flights where id = ?");
           preparedStatement.setLong(1,flights.getId());
           preparedStatement.executeUpdate();
           preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAircraftFromDb(Aircrafts aircrafts) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM aircrafts where id = ?");
            preparedStatement.setLong(1, aircrafts.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
