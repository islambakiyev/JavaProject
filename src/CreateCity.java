import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCity extends Container {
    MainFrame frame;

    public CreateCity(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JLabel cityName = new JLabel("CITY NAME:");
        cityName.setBounds(100,100,150,50);
        add(cityName);

        JTextField cityNameField = new JTextField();
        cityNameField.setLocation(200,110);
        cityNameField.setSize(200,30);
        add(cityNameField);

        JLabel countryName = new JLabel("COUNTRY NAME:");
        countryName.setBounds(100,150,150,50);
        add(countryName);

        JTextField countryNameField = new JTextField();
        countryNameField.setLocation(200,170);
        countryNameField.setSize(200,30);
        add(countryNameField);

        JLabel cityShortName = new JLabel("CITY SHORT NAME");
        cityShortName.setBounds(100,200,150,50);
        add(cityShortName);

        JTextField cityShortNameField = new JTextField();
        cityShortNameField.setLocation(200,240);
        cityShortNameField.setSize(200,30);
        add(cityShortNameField);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(100,380,120,30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = cityNameField.getText();
                cityNameField.setText("");
                String country = countryNameField.getText();
                countryNameField.setText("");
                String cityShortName = cityShortNameField.getText();
                cityShortNameField.setText("");

                Cities city = new Cities(null,name,country,cityShortName);
                PackageData pd = new PackageData("ADD CITY",city);
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
