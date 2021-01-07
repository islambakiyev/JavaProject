import java.io.Serializable;

public class Flights implements Serializable {
    Long id;
    int airCraftId;
    int departureCityId;
    int arrivalCityId;
    String departureTime;
    int economPlacePrice;
    int businessPlacePrice;

    public Flights(Long id, int airCraftId, int departureCityId, int arrivalCityId, String departureTime, int economPlacePrice, int businessPlacePrice) {
        this.id = id;
        this.airCraftId = airCraftId;
        this.departureCityId = departureCityId;
        this.arrivalCityId = arrivalCityId;
        this.departureTime = departureTime;
        this.economPlacePrice = economPlacePrice;
        this.businessPlacePrice = businessPlacePrice;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", airCraftId=" + airCraftId +
                ", departureCityId=" + departureCityId +
                ", arrivalCityId=" + arrivalCityId +
                ", departureTime='" + departureTime + '\'' +
                ", economPlacePrice=" + economPlacePrice +
                ", businessPlacePrice=" + businessPlacePrice +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAirCraftId() {
        return airCraftId;
    }

    public void setAirCraftId(int airCraftId) {
        this.airCraftId = airCraftId;
    }

    public int getDepartureCityId() {
        return departureCityId;
    }

    public void setDepartureCityId(int departureCityId) {
        this.departureCityId = departureCityId;
    }

    public int getArrivalCityId() {
        return arrivalCityId;
    }

    public void setArrivalCityId(int arrivalCityId) {
        this.arrivalCityId = arrivalCityId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getEconomPlacePrice() {
        return economPlacePrice;
    }

    public void setEconomPlacePrice(int economPlacePrice) {
        this.economPlacePrice = economPlacePrice;
    }

    public int getBusinessPlacePrice() {
        return businessPlacePrice;
    }

    public void setBusinessPlacePrice(int businessPlacePrice) {
        this.businessPlacePrice = businessPlacePrice;
    }
}
