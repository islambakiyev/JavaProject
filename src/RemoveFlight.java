import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveFlight extends Container {
    MainFrame frame;
    private JTable table;
    private JScrollPane scrollPane;
    private String header [] = {"ID","Aircraft","Departure city","Arrival City","Departure Time"," Econom Price", "Business Price"};

    public RemoveFlight(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JLabel header = new JLabel("LIST OF FLIGHTS");
        header.setSize(300,30);
        header.setLocation(10,50);
        header.setFont(new Font("Arial",Font.BOLD,14));
        add(header);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);
        add(table);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(600,200);
        scrollPane.setLocation(10,100);
        add(scrollPane);

        JLabel chooseId = new JLabel("WRITE ID FOR DELETE:");
        chooseId.setBounds(10,300,150,50);
        add(chooseId);

        JTextField chooseIdField = new JTextField();
        chooseIdField.setLocation(160,310);
        chooseIdField.setSize(200,30);
        add(chooseIdField);

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setBounds(35,400,150,40);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id = Long.valueOf(chooseIdField.getText());
                chooseIdField.setText("");

                Flights flight = new Flights(id);
                PackageData packageData = new PackageData("DELETE FLIGHT",flight);
                MainFrame.sendPackage(packageData);
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setBounds(200,400,150,40);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showRemovePage();
            }
        });
    }

    public void generateTable(ArrayList<Flights> flightsArrayList){
        Object data[][] = new Object[flightsArrayList.size()][7];
        for(int i = 0; i< flightsArrayList.size(); i++){
            data[i][0] = flightsArrayList.get(i).getId();
            data[i][1] = flightsArrayList.get(i).getAircraft();
            data[i][2] = flightsArrayList.get(i).getCity();
            data[i][3] = flightsArrayList.get(i).getArrivalCity();
            data[i][4] = flightsArrayList.get(i).getDepartureTime();
            data[i][5] = flightsArrayList.get(i).getEconomPlacePrice();
            data[i][6] = flightsArrayList.get(i).getBusinessPlacePrice();
        }

        DefaultTableModel model = new DefaultTableModel(data,header);
        table.setModel(model);
    }
}
