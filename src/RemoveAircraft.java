import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveAircraft extends Container {
    MainFrame frame;
    JComboBox removeAircraftsBox;

    public RemoveAircraft (MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JLabel aircraftName = new JLabel("CHOOSE AIRCRAFT FOR DELETE:");
        aircraftName.setBounds(100,100,250,50);
        add(aircraftName);

        removeAircraftsBox = new JComboBox();
        removeAircraftsBox.setLocation(300,110);
        removeAircraftsBox.setSize(200,30);
        add(removeAircraftsBox);

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setBounds(100,200,120,30);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aircraftIndex = removeAircraftsBox.getSelectedIndex();
                Long aircraftId = frame.fromIndexToIdAirCraftChange(aircraftIndex);
                Aircrafts aircrafts = new Aircrafts(aircraftId);
                PackageData packageData = new PackageData("REMOVE AIRCRAFT",aircrafts);
                MainFrame.sendPackage(packageData);
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setBounds(300,200,120,30);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showRemovePage();
            }
        });
    }

    public void refreshData(ArrayList<Aircrafts> aircraftsCollection){
        removeAircraftsBox.removeAllItems();
        for(int i = 0; i<aircraftsCollection.size();i++){
            removeAircraftsBox.addItem(aircraftsCollection.get(i).name);
        }
    }
}
