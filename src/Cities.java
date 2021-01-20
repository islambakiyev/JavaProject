import java.io.Serializable;

public class Cities implements Serializable {
    Long id;
    String name;
    String country;
    String shortName;

    public Cities(Long id) {
        this.id = id;
    }

    public Cities(Long id, String name, String country, String shortName) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", shortName='" + shortName + '\'' +
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
