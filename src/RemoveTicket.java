import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveTicket extends Container {
    MainFrameKassir mainFrameKassir;
    JComboBox passengers;

    public RemoveTicket(MainFrameKassir mainFrameKassir){
        this.mainFrameKassir = mainFrameKassir;
        setSize(700,700);
        setLayout(null);

        JLabel choosePassenger = new JLabel("CHOOSE TICKET FOR DELETE:");
        choosePassenger.setBounds(20,250,200,50);
        add(choosePassenger);

        passengers = new JComboBox();
        passengers.setLocation(250,260);
        passengers.setSize(400,30);
        add(passengers);

        JButton addButton = new JButton("DELETE");
        addButton.setBounds(150,380,120,30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id = Long.valueOf(passengers.getSelectedIndex());
                Long passengerId = mainFrameKassir.fromIndexToIdChange(id);
                Tickets ticket = new Tickets(passengerId);
                PackageData packageData = new PackageData("DELETE TICKET",ticket);
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
            passengers.addItem(tickets.get(i).surname+"/"+tickets.get(i).getPassport_number()+"/"+tickets.get(i).getFlight_id());
        }
    }
}
