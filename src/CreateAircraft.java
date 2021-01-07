import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAircraft extends Container {
    MainFrame frame;

    public CreateAircraft(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JLabel aircraftName = new JLabel("NAME:");
        aircraftName.setBounds(100,100,150,50);
        add(aircraftName);

        JTextField aircraftNameField = new JTextField();
        aircraftNameField.setLocation(200,110);
        aircraftNameField.setSize(200,30);
        add(aircraftNameField);

        JLabel aircraftModel = new JLabel("MODEL:");
        aircraftModel.setBounds(100,150,150,50);
        add(aircraftModel);

        JTextField aircraftModelField = new JTextField();
        aircraftModelField.setLocation(200,170);
        aircraftModelField.setSize(200,30);
        add(aircraftModelField);

        JLabel businessClassCapacity = new JLabel("Business class capacity");
        businessClassCapacity.setBounds(100,200,150,50);
        add(businessClassCapacity);

        JTextField businessClassCapacityField = new JTextField();
        businessClassCapacityField.setLocation(200,240);
        businessClassCapacityField.setSize(200,30);
        add(businessClassCapacityField);

        JLabel economClassCapacity = new JLabel("Econom class capacity");
        economClassCapacity.setBounds(100,250,150,50);
        add(economClassCapacity);

        JTextField economClassCapacityField = new JTextField();
        economClassCapacityField.setLocation(200,310);
        economClassCapacityField.setSize(200,30);
        add(economClassCapacityField);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(100,380,120,30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = aircraftNameField.getText();
                aircraftNameField.setText("");
                String model = aircraftModelField.getText();
                aircraftModelField.setText("");
                int businessCapacity = Integer.parseInt(businessClassCapacityField.getText());
                businessClassCapacityField.setText("");
                int economCapacity = Integer.parseInt(economClassCapacityField.getText());
                economClassCapacityField.setText("");
                Aircrafts aircraft = new Aircrafts(null,name,model,businessCapacity,economCapacity);
                PackageData pd = new PackageData("ADD AIRCRAFT", aircraft);
                MainFrame.sendPackage(pd);

            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setBounds(300,380,120,30);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.backToCreatePageMenu();
            }
        });


    }
}
