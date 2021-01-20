import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateTicket extends Container {
    MainFrameKassir mainFrameKassir;
    JComboBox flightsCollection;

    public CreateTicket(MainFrameKassir mainFrameKassir){
        this.mainFrameKassir = mainFrameKassir;
        setSize(700,700);
        setLayout(null);

        JLabel chooseFlight = new JLabel("CHOOSE FLIGHT:");
        chooseFlight.setBounds(100,100,150,50);
        add(chooseFlight);

        flightsCollection = new JComboBox();
        flightsCollection.setLocation(250,110);
        flightsCollection.setSize(300,30);
        add(flightsCollection);

        JLabel name = new JLabel("NAME:");
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

                Tickets ticket = new Tickets(null,id,name,surname,passport,classType);
                PackageData packageData = new PackageData("CREATE TICKET",ticket);
                MainFrameKassir.sendPackage(packageData);
            }
        });


        JButton backButton = new JButton("BACK");
        backButton.setBounds(320,380,120,30);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameKassir.showMainMenuKassir();
            }
        });

    }

    public void refreshData(ArrayList<Flights> flights){
        flightsCollection.removeAllItems();
        for(int i = 0; i<flights.size();i++){
            flightsCollection.addItem(flights.get(i).arrivalCity+"/"+flights.get(i).getCity()+"/"+flights.get(i).getDepartureTime()+"/"+flights.get(i).aircraft);
        }
    }
}
