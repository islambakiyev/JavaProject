import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemovePage extends Container {
    MainFrame frame;

    public RemovePage(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JButton removeCity = new JButton("REMOVE CITY");
        removeCity.setBounds(150,100,200,50);
        add(removeCity);
        removeCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showRemoveCitiesPage();
                PackageData packageData1 = new PackageData("remove cities");
                MainFrame.sendPackage(packageData1);
                MainFrame.removeCity.refreshData(frame.readCities());
            }
        });

        JButton removeAircraft = new JButton("REMOVE AIRCRAFT");
        removeAircraft.setBounds(150,150,200,50);
        add(removeAircraft);
        removeAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showRemoveAircraftsPage();
                PackageData packageData = new PackageData("REMOVE AIRCRAFTS PAGE");
                MainFrame.sendPackage(packageData);
                MainFrame.removeAircraft.refreshData(frame.readAircrafts());
            }
        });

        JButton removeFlight = new JButton("REMOVE FLIGHT");
        removeFlight.setBounds(150,200,200,50);
        add(removeFlight);
        removeFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.removeFlightsPage();
                PackageData packageData = new PackageData("REMOVE FLIGHT");
                MainFrame.sendPackage(packageData);
                MainFrame.removeFlight.generateTable(frame.readFlights());

            }
        });

        JButton backToMainMenu = new JButton("BACK TO MAIN MENU");
        backToMainMenu.setBounds(150,250,200,50);
        add(backToMainMenu);
        backToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showMainMenu();
            }
        });

    }
}
