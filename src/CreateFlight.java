import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateFlight extends Container {
    MainFrame frame;
    JComboBox departureCityIdField;
    JComboBox aircraftIdField;
    JComboBox arrivalCityIdField;

    public CreateFlight(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);


        JLabel aircraftId = new JLabel("AIRCRAFT ID:");
        aircraftId.setBounds(100,100,150,50);
        add(aircraftId);

        aircraftIdField = new JComboBox();
        aircraftIdField.setLocation(250,110);
        aircraftIdField.setSize(200,30);
        add(aircraftIdField);

        JLabel departureCityId = new JLabel("Departure city id:");
        departureCityId.setBounds(100,150,150,50);
        add(departureCityId);

        departureCityIdField = new JComboBox();
        departureCityIdField.setLocation(250,170);
        departureCityIdField.setSize(200,30);
        add(departureCityIdField);

        JLabel arrivalCityId = new JLabel("Arrival city id");
        arrivalCityId.setBounds(100,200,150,50);
        add(arrivalCityId);

        arrivalCityIdField = new JComboBox();
        arrivalCityIdField.setLocation(250,220);
        arrivalCityIdField.setSize(200,30);
        add(arrivalCityIdField);

        JLabel departureTime = new JLabel("Departure Time");
        departureTime.setBounds(100,250,150,50);
        add(departureTime);

        JTextField departureTimeField = new JTextField();
        departureTimeField.setLocation(250,270);
        departureTimeField.setSize(200,30);
        add(departureTimeField);

        JLabel economPlacePrice = new JLabel("Econom Place Price");
        economPlacePrice.setBounds(100,300,150,50);
        add(economPlacePrice);

        JTextField economPlacePriceField = new JTextField();
        economPlacePriceField.setLocation(250,320);
        economPlacePriceField.setSize(200,30);
        add(economPlacePriceField);

        JLabel businessPlacePrice = new JLabel("Business Place Price");
        businessPlacePrice.setBounds(100,350,150,50);
        add(businessPlacePrice);

        JTextField businessPlacePriceField = new JTextField();
        businessPlacePriceField.setLocation(250,370);
        businessPlacePriceField.setSize(200,30);
        add(businessPlacePriceField);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(100,480,120,30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int airCraftId = aircraftIdField.getSelectedIndex();
                int idCraft = frame.fromIndexToIdAirCraft(airCraftId);

                int departureCityIdNumber = departureCityIdField.getSelectedIndex();
                int idDepartureCities = frame.fromIndexToId(departureCityIdNumber);

                int arrivalCityIdNumber = arrivalCityIdField.getSelectedIndex();
                int idArrivalCities = frame.fromIndexToId(arrivalCityIdNumber);

                String departureTime = departureTimeField.getText();
                departureTimeField.setText("");

                int economPrice = Integer.parseInt(economPlacePriceField.getText());
                economPlacePriceField.setText("");

                int businessPrice = Integer.parseInt(businessPlacePriceField.getText());
                businessPlacePriceField.setText("");

                Flights flight = new Flights(null,idCraft,idDepartureCities,idArrivalCities,departureTime,economPrice,businessPrice);
                PackageData pd = new PackageData("ADD FLIGHT",flight);
                MainFrame.sendPackage(pd);
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setBounds(300,480,120,30);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.backToCreatePageMenu();
            }
        });
    }

    public void refreshData(ArrayList<Cities> citiesCollection){
        departureCityIdField.removeAllItems();
        for(int i = 0; i<citiesCollection.size();i++){
            departureCityIdField.addItem(citiesCollection.get(i).name);
        }
    }

    public void refreshDataAircraft(ArrayList<Aircrafts> aircraftCollection){
        aircraftIdField.removeAllItems();
        for(int i = 0; i<aircraftCollection.size();i++){
            aircraftIdField.addItem(aircraftCollection.get(i).name);
        }
    }

    public void refreshDataArrivalCities(ArrayList<Cities> citiesCollection){
        arrivalCityIdField.removeAllItems();
        for(int i = 0; i<citiesCollection.size();i++){
            arrivalCityIdField.addItem(citiesCollection.get(i).name);
        }
    }
}
