import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeAircraft extends Container {
    MainFrame frame;
    JComboBox changeAircraftBox;

    public ChangeAircraft(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JLabel chooseAircraft = new JLabel("CHOOSE AIRCRAFT:");
        chooseAircraft.setBounds(100,100,150,50);
        add(chooseAircraft);

        changeAircraftBox = new JComboBox();
        changeAircraftBox.setLocation(340,110);
        changeAircraftBox.setSize(200,30);
        add(changeAircraftBox);

        JLabel newAircraftName = new JLabel("NEW AIRCRAFT NAME:");
        newAircraftName.setBounds(100,150,150,50);
        add(newAircraftName);

        JTextField newAircraftNameField = new JTextField();
        newAircraftNameField.setLocation(340,160);
        newAircraftNameField.setSize(200,30);
        add(newAircraftNameField);

        JLabel newModel = new JLabel("NEW MODEL:");
        newModel.setBounds(100,200,150,50);
        add(newModel);

        JTextField newModelField = new JTextField();
        newModelField.setLocation(340,210);
        newModelField.setSize(200,30);
        add(newModelField);

        JLabel newBusinessClassCapacity = new JLabel("NEW BUSINESS CLASS CAPACITY:");
        newBusinessClassCapacity.setBounds(100,250,200,50);
        add(newBusinessClassCapacity);

        JTextField newBusinessClassCapacityField = new JTextField();
        newBusinessClassCapacityField.setLocation(340,260);
        newBusinessClassCapacityField.setSize(200,30);
        add(newBusinessClassCapacityField);

        JLabel newEconomClassCapacity = new JLabel("NEW ECONOM CLASS CAPACITY:");
        newEconomClassCapacity.setBounds(100,300,200,50);
        add(newEconomClassCapacity);

        JTextField newEconomClassCapacityField = new JTextField();
        newEconomClassCapacityField.setLocation(340,320);
        newEconomClassCapacityField.setSize(200,30);
        add(newEconomClassCapacityField);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(140,380,120,30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aircraftIndex = changeAircraftBox.getSelectedIndex();
                Long aircraftId = frame.fromIndexToIdAirCraftChange(aircraftIndex);
                String name = newAircraftNameField.getText();
                newAircraftNameField.setText("");

                String model = newModelField.getText();
                newModelField.setText("");

                int businessCapacity = Integer.parseInt(newBusinessClassCapacityField.getText());
                newBusinessClassCapacityField.setText("");

                int economCapacity = Integer.parseInt(newEconomClassCapacityField.getText());
                newEconomClassCapacityField.setText("");

                Aircrafts aircrafts = new Aircrafts(aircraftId,name,model,businessCapacity,economCapacity);
                PackageData pd = new PackageData("CHANGE AIRCRAFT",aircrafts);
                MainFrame.sendPackage(pd);
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setBounds(340,380,120,30);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showChangePage();
            }
        });

    }

    public void refreshData(ArrayList<Aircrafts> aircraftsCollection){
        changeAircraftBox.removeAllItems();
        for(int i = 0; i<aircraftsCollection.size();i++){
            changeAircraftBox.addItem(aircraftsCollection.get(i).name);
        }
    }
}
