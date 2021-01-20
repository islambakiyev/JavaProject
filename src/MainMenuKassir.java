import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuKassir extends Container {
    MainFrameKassir frameKassir;

    public MainMenuKassir(MainFrameKassir frameKassir){
        this.frameKassir = frameKassir;
        setSize(700,700);
        setLayout(null);

        JButton createPage = new JButton("CREATE TICKET");
        createPage.setBounds(150,100,200,50);
        add(createPage);
        createPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameKassir.showCreateTicket();
                PackageData packageData = new PackageData("get all flights");
                MainFrameKassir.sendPackage(packageData);

                MainFrameKassir.createTicket.refreshData(frameKassir.readFlights());
            }
        });

        JButton changePage = new JButton("CHANGE TICKET");
        changePage.setBounds(150,150,200,50);
        add(changePage);
        changePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameKassir.showChangeTicket();
                PackageData packageData = new PackageData("get all passengers");
                MainFrameKassir.sendPackage(packageData);

                PackageData packageData1 = new PackageData("get all flights for change");
                MainFrameKassir.sendPackage(packageData1);

                MainFrameKassir.changeTicket.refreshDataPassenger(frameKassir.readTickets());
                MainFrameKassir.changeTicket.refreshDataChange(frameKassir.readFlights());
            }
        });

        JButton removePage = new JButton("REMOVE TICKET");
        removePage.setBounds(150,200,200,50);
        add(removePage);
        removePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameKassir.showRemoveTicket();
                PackageData packageData = new PackageData("get all passengers for delete");
                MainFrameKassir.sendPackage(packageData);

                MainFrameKassir.removeTicket.refreshDataPassenger(frameKassir.readTickets());
            }
        });
    }
}
