import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    MainFrame frame;

    public MainMenu(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JButton createPage = new JButton("CREATE PAGE");
        createPage.setBounds(150,100,200,50);
        add(createPage);
        createPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showCreatePage();
            }
        });

        JButton changePage = new JButton("CHANGE PAGE");
        changePage.setBounds(150,150,200,50);
        add(changePage);
        changePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showChangePage();
            }
        });

        JButton removePage = new JButton("REMOVE PAGE");
        removePage.setBounds(150,200,200,50);
        add(removePage);
        removePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showRemovePage();
            }
        });
    }
}
