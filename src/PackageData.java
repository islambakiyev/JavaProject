import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    Aircrafts aircraft;
    Cities city;
    Flights flight;
    Tickets ticket;

    ArrayList<Aircrafts> aircrafts;
    ArrayList<Cities> cities;
    ArrayList<Flights> flights;
    ArrayList<Tickets> tickets;

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public PackageData(String operationType, Aircrafts aircraft) {
        this.operationType = operationType;
        this.aircraft = aircraft;
    }

    public PackageData(String operationType, Cities city) {
        this.operationType = operationType;
        this.city = city;
    }

    public PackageData(String operationType, Flights flight) {
        this.operationType = operationType;
        this.flight = flight;
    }

    public PackageData(String operationType, Tickets ticket) {
        this.operationType = operationType;
        this.ticket = ticket;
    }

    public PackageData(ArrayList<Aircrafts> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Aircrafts getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    public ArrayList<Aircrafts> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(ArrayList<Aircrafts> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public ArrayList<Cities> getCities() {
        return cities;
    }

    public void setCities(ArrayList<Cities> cities) {
        this.cities = cities;
    }

    public ArrayList<Flights> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flights> flights) {
        this.flights = flights;
    }

    public ArrayList<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Tickets> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", aircraft=" + aircraft +
                ", city=" + city +
                ", flight=" + flight +
                ", ticket=" + ticket +
                ", aircrafts=" + aircrafts +
                ", cities=" + cities +
                ", flights=" + flights +
                ", tickets=" + tickets +
                '}';
    }
}
