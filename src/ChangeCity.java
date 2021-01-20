import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeCity extends Container {
    MainFrame frame;
    JComboBox departureCityIdField;

    public ChangeCity(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JLabel cityName = new JLabel("CHOOSE CITY:");
        cityName.setBounds(100,100,150,50);
        add(cityName);

        departureCityIdField = new JComboBox();
        departureCityIdField.setLocation(220,110);
        departureCityIdField.setSize(200,30);
        add(departureCityIdField);


        JLabel newCityName = new JLabel("NEW CITY NAME:");
        newCityName.setBounds(100,150,150,50);
        add(newCityName);

        JTextField cityNameField = new JTextField();
        cityNameField.setLocation(220,160);
        cityNameField.setSize(200,30);
        add(cityNameField);

        JLabel countryName = new JLabel("COUNTRY NAME:");
        countryName.setBounds(100,200,150,50);
        add(countryName);

        JTextField countryNameField = new JTextField();
        countryNameField.setLocation(220,210);
        countryNameField.setSize(200,30);
        add(countryNameField);

        JLabel cityShortName = new JLabel("CITY SHORT NAME:");
        cityShortName.setBounds(100,250,150,50);
        add(cityShortName);

        JTextField cityShortNameField = new JTextField();
        cityShortNameField.setLocation(220,260);
        cityShortNameField.setSize(200,30);
        add(cityShortNameField);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(100,380,120,30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int departureCityIdNumber = departureCityIdField.getSelectedIndex();
                Long idDepartureCities = frame.fromIndexToIdChange(departureCityIdNumber);

                String name = cityNameField.getText();
                cityNameField.setText("");
                String country = countryNameField.getText();
                countryNameField.setText("");
                String cityShortName = cityShortNameField.getText();
                cityShortNameField.setText("");

                Cities city = new Cities(idDepartureCities,name,country,cityShortName);
                PackageData pd = new PackageData("CHANGE CITY",city);
                MainFrame.sendPackage(pd);
            }
        });


        JButton backButton = new JButton("BACK");
        backButton.setBounds(300,380,120,30);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showChangePage();
            }
        });
    }


    public void refreshData(ArrayList<Cities> citiesCollection){
        departureCityIdField.removeAllItems();
        for(int i = 0; i<citiesCollection.size();i++){
            departureCityIdField.addItem(citiesCollection.get(i).name);
        }
    }
}
