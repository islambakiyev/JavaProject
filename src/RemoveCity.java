import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RemoveCity extends Container {
    MainFrame frame;
    JComboBox removeCitiesBox;

    public RemoveCity(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JLabel cityName = new JLabel("CHOOSE CITY FOR DELETE:");
        cityName.setBounds(100,100,250,50);
        add(cityName);

        removeCitiesBox = new JComboBox();
        removeCitiesBox.setLocation(300,110);
        removeCitiesBox.setSize(200,30);
        add(removeCitiesBox);

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setBounds(100,200,120,30);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cityIndex = removeCitiesBox.getSelectedIndex();
                Long cityId = frame.fromIndexToIdChange(cityIndex);
                Cities cities = new Cities(cityId);
                PackageData pd = new PackageData("REMOVE CITY",cities);
                MainFrame.sendPackage(pd);
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

    public void refreshData(ArrayList<Cities> citiesCollection){
        removeCitiesBox.removeAllItems();
        for(int i = 0; i<citiesCollection.size();i++){
            removeCitiesBox.addItem(citiesCollection.get(i).name);
        }
    }
}
