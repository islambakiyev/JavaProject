import java.io.Serializable;

public class Aircrafts implements Serializable {
    Long id;
    String name;
    String model;
    int businessClassCapacity;
    int economClassCapacity;

    public Aircrafts(Long id) {
        this.id = id;
    }

    public Aircrafts(Long id, String name, String model, int businessClassCapacity, int economClassCapacity) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.businessClassCapacity = businessClassCapacity;
        this.economClassCapacity = economClassCapacity;
    }

    @Override
    public String toString() {
        return "Aircrafts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", businessClassCapacity=" + businessClassCapacity +
                ", economClassCapacity=" + economClassCapacity +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBusinessClassCapacity() {
        return businessClassCapacity;
    }

    public void setBusinessClassCapacity(int businessClassCapacity) {
        this.businessClassCapacity = businessClassCapacity;
    }

    public int getEconomClassCapacity() {
        return economClassCapacity;
    }

    public void setEconomClassCapacity(int economClassCapacity) {
        this.economClassCapacity = economClassCapacity;
    }
}
