import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeFlight extends Container {
    MainFrame frame;
    private JTable table;
    private JScrollPane scrollPane;
    private String header [] = {"ID","Aircraft","Departure city","Arrival City","Departure Time"," Econom Price", "Business Price"};

    public ChangeFlight (MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JLabel header = new JLabel("LIST OF FLIGHTS");
        header.setSize(300,30);
        header.setLocation(10,50);
        header.setFont(new Font("Arial",Font.BOLD,14));
        add(header);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);
        add(table);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(600,200);
        scrollPane.setLocation(10,100);
        add(scrollPane);

        JLabel chooseId = new JLabel("WRITE ID FOR CHANGE:");
        chooseId.setBounds(10,300,150,50);
        add(chooseId);

        JTextField chooseIdField = new JTextField();
        chooseIdField.setLocation(160,310);
        chooseIdField.setSize(200,30);
        add(chooseIdField);

        JLabel newAircraft = new JLabel("NEW AIRCRAFT:");
        newAircraft.setBounds(10,340,150,50);
        add(newAircraft);

        JTextField newAircraftField = new JTextField();
        newAircraftField.setLocation(160,350);
        newAircraftField.setSize(200,30);
        add(newAircraftField);

        JLabel newDepartureCity = new JLabel("NEW DEPARTURE CITY:");
        newDepartureCity.setBounds(10,380,150,50);
        add(newDepartureCity);

        JTextField newDepartureCityField = new JTextField();
        newDepartureCityField.setLocation(160,390);
        newDepartureCityField.setSize(200,30);
        add(newDepartureCityField);

        JLabel newArrivalCity = new JLabel("NEW ARRIVAL CITY:");
        newArrivalCity.setBounds(10,420,150,50);
        add(newArrivalCity);

        JTextField newArrivalCityField = new JTextField();
        newArrivalCityField.setLocation(160,430);
        newArrivalCityField.setSize(200,30);
        add(newArrivalCityField);

        JLabel newDepartureTime = new JLabel("NEW DEPARTURE TIME:");
        newDepartureTime.setBounds(10,460,150,50);
        add(newDepartureTime);

        JTextField newDepartureTimeField = new JTextField();
        newDepartureTimeField.setLocation(160,470);
        newDepartureTimeField.setSize(200,30);
        add(newDepartureTimeField);

        JLabel newEconomPrice = new JLabel("NEW ECONOM PRICE:");
        newEconomPrice.setBounds(10,500,150,50);
        add(newEconomPrice);

        JTextField newEconomPriceField = new JTextField();
        newEconomPriceField.setLocation(160,510);
        newEconomPriceField.setSize(200,30);
        add(newEconomPriceField);

        JLabel newBusinessPrice = new JLabel("NEW BUSINESS PRICE:");
        newBusinessPrice.setBounds(10,540,150,50);
        add(newBusinessPrice);

        JTextField newBusinessPriceField = new JTextField();
        newBusinessPriceField.setLocation(160,550);
        newBusinessPriceField.setSize(200,30);
        add(newBusinessPriceField);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(35,600,150,40);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id = Long.valueOf(chooseIdField.getText());
                chooseIdField.setText("");

                String aircraft = newAircraftField.getText();
                newAircraftField.setText("");

                String departureCity = newDepartureCityField.getText();
                newDepartureCityField.setText("");

                String arrivalCity = newArrivalCityField.getText();
                newArrivalCityField.setText("");

                String departureTime = newDepartureTimeField.getText();
                newDepartureTimeField.setText("");

                int economPrice = Integer.parseInt(newEconomPriceField.getText());
                newEconomPriceField.setText("");

                int businessPrice = Integer.parseInt(newBusinessPriceField.getText());
                newBusinessPriceField.setText("");

                Flights flight = new Flights(id,aircraft,arrivalCity,departureTime,economPrice,businessPrice,departureCity);
                PackageData packageData = new PackageData("CHANGE FLIGHT",flight);
                MainFrame.sendPackage(packageData);

            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setBounds(200,600,150,40);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showChangePage();
            }
        });

    }

    public void generateTable(ArrayList<Flights> flightsArrayList){
        Object data[][] = new Object[flightsArrayList.size()][7];
        for(int i = 0; i< flightsArrayList.size(); i++){
            data[i][0] = flightsArrayList.get(i).getId();
            data[i][1] = flightsArrayList.get(i).getAircraft();
            data[i][2] = flightsArrayList.get(i).getCity();
            data[i][3] = flightsArrayList.get(i).getArrivalCity();
            data[i][4] = flightsArrayList.get(i).getDepartureTime();
            data[i][5] = flightsArrayList.get(i).getEconomPlacePrice();
            data[i][6] = flightsArrayList.get(i).getBusinessPlacePrice();
        }

        DefaultTableModel model = new DefaultTableModel(data,header);
        table.setModel(model);
    }
}
