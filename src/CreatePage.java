import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePage extends Container {
    MainFrame frame;

    public CreatePage(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JButton createAircraft = new JButton("CREATE AIRCRAFT");
        createAircraft.setBounds(150,100,200,50);
        add(createAircraft);
        createAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showCreateAircraftPage();
            }
        });

        JButton createCity = new JButton("CREATE CITY");
        createCity.setBounds(150,150,200,50);
        add(createCity);
        createCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showCreateCityPage();
            }
        });

        JButton createFlight = new JButton("CREATE FLIGHT");
        createFlight.setBounds(150,200,200,50);
        add(createFlight);
        createFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showCreateFlightPage();
                PackageData packageData = new PackageData("cities");
                MainFrame.sendPackage(packageData);

                PackageData packageDataArrivalCities = new PackageData("arrival cities");
                MainFrame.sendPackage(packageDataArrivalCities);

                PackageData packageDataAircrafts = new PackageData("aircrafts");
                MainFrame.sendPackage(packageDataAircrafts);

                MainFrame.createFlight.refreshData(frame.readCities());
                MainFrame.createFlight.refreshDataArrivalCities(frame.readCities());
                MainFrame.createFlight.refreshDataAircraft(frame.readAircrafts());
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
