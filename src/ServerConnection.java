import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerConnection extends Container {
    MainFrame frame;

    public ServerConnection(MainFrame frame){
        this.frame = frame;
        setSize(700,700);
        setLayout(null);

        JLabel entranceToServer = new JLabel("СОЕДИНИТЬСЯ С СЕРВЕРОМ");
        entranceToServer.setBounds(170,150,200,30);
        add(entranceToServer);

        JLabel ipLabel = new JLabel("IP");
        ipLabel.setBounds(120,200,200,30);
        add(ipLabel);

        JTextField ipField = new JTextField();
        ipField.setLocation(170,200);
        ipField.setSize(200,30);
        add(ipField);

        JLabel portLabel = new JLabel("PORT");
        portLabel.setBounds(120,230,200,30);
        add(portLabel);

        JTextField portField = new JTextField();
        portField.setLocation(170,230);
        portField.setSize(200,30);
        add(portField);

        JButton connectButton = new JButton("Подключиться");
        connectButton.setBounds(170,280,200,30);
        add(connectButton);
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = ipField.getText();
                int port = Integer.parseInt(portField.getText());
                boolean check = MainFrame.connectToServer(ip,port);
                if(check){
                    frame.showMainMenu();
                }

            }
        });




    }

}
