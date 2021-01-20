import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePage extends Container {
    MainFrame frame;

    public ChangePage(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JButton changeCity = new JButton("CHANGE CITY");
        changeCity.setBounds(150,100,200,50);
        add(changeCity);
        changeCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showChangeCitiesPage();
                PackageData packageData1 = new PackageData("change cities");
                MainFrame.sendPackage(packageData1);

                MainFrame.changeCity.refreshData(frame.readCities());
            }
        });

        JButton changeAircraft = new JButton("CHANGE AIRCRAFT");
        changeAircraft.setBounds(150,150,200,50);
        add(changeAircraft);
        changeAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showChangeAircraftsPage();
                PackageData packageData2 = new PackageData("aircrafts list");
                MainFrame.sendPackage(packageData2);
                MainFrame.changeAircraft.refreshData(frame.readAircrafts());
            }
        });

        JButton changeFlight = new JButton("CHANGE FLIGHT");
        changeFlight.setBounds(150,200,200,50);
        add(changeFlight);
        changeFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showChangeFlightsPage();
                PackageData packageData = new PackageData("flights list");
                MainFrame.sendPackage(packageData);
                MainFrame.changeFlight.generateTable(frame.readFlights());
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
