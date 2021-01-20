import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeTicket extends Container {
    MainFrameKassir mainFrameKassir;
    JComboBox passengers;
    JComboBox flightsCollection;

    public ChangeTicket(MainFrameKassir mainFrameKassir){
        this.mainFrameKassir = mainFrameKassir;
        setSize(700,700);
        setLayout(null);

        JLabel choosePassenger = new JLabel("CHOOSE PASSENGER:");
        choosePassenger.setBounds(100,50,150,50);
        add(choosePassenger);

        passengers = new JComboBox();
        passengers.setLocation(250,60);
        passengers.setSize(300,30);
        add(passengers);

        JLabel chooseFlights = new JLabel("CHOOSE NEW FLIGHT:");
        chooseFlights.setBounds(100,100,150,50);
        add(chooseFlights);

        flightsCollection = new JComboBox();
        flightsCollection.setBounds(250,110,300,30);
        add(flightsCollection);

        JLabel name = new JLabel("NEW NAME:");
        name.setBounds(150,160,150,50);
        add(name);

        JTextField nameField = new JTextField();
        nameField.setBounds(250,170,200,30);
        add(nameField);

        JLabel surname = new JLabel("SURNAME:");
        surname.setBounds(150,210,150,50);
        add(surname);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(250,220,200,30);
        add(surnameField);

        JLabel passportNumber = new JLabel("PASSPORT №");
        passportNumber.setBounds(150,260,150,30);
        add(passportNumber);

        JTextField passportNumberField = new JTextField();
        passportNumberField.setBounds(250,266,200,30);
        add(passportNumberField);

        JLabel classType = new JLabel("CLASS:");
        classType.setBounds(150,310,150,50);
        add(classType);

        JTextField classTypeField = new JTextField();
        classTypeField.setBounds(250,320,200,30);
        add(classTypeField);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(150,380,120,30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long idPassenger = Long.valueOf(passengers.getSelectedIndex());
                Long idNumberOfPassenger = mainFrameKassir.fromIndexToIdChange(idPassenger);

                int flightId = flightsCollection.getSelectedIndex();
                int id = mainFrameKassir.fromIndexToIdFlight(flightId);

                String name = nameField.getText();
                nameField.setText("");

                String surname = surnameField.getText();
                surnameField.setText("");

                String passport = passportNumberField.getText();
                passportNumberField.setText("");

                String classType = classTypeField.getText();
                classTypeField.setText("");

                Tickets ticket = new Tickets(idNumberOfPassenger,id,name,surname,passport,classType);
                PackageData packageData = new PackageData("CHANGE TICKET",ticket);
                MainFrameKassir.sendPackage(packageData);
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setBounds(300,380,120,30);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameKassir.showMainMenuKassir();
            }
        });
    }

    public void refreshDataPassenger(ArrayList<Tickets> tickets){
        passengers.removeAllItems();
        for(int i = 0; i<tickets.size();i++){
            passengers.addItem(tickets.get(i).surname+"/"+tickets.get(i).getPassport_number());
        }
    }

    public void refreshDataChange(ArrayList<Flights> flights){
        flightsCollection.removeAllItems();
        for(int i = 0; i<flights.size();i++){
            flightsCollection.addItem(flights.get(i).arrivalCity+"/"+flights.get(i).getCity()+"/"+flights.get(i).getDepartureTime()+"/"+flights.get(i).aircraft);
        }
    }
}
