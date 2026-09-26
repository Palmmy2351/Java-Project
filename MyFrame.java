import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class MyFrame extends JFrame {
    Mypanel panel = new Mypanel();
    JTextField textField = new JTextField(10);
    JButton button = new JButton("Creat Meteor");
    MyFrame() {
        setSize(690, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Number of meteorites"));
        controlPanel.add(textField);
        controlPanel.add(button);

        add(panel);
        add(controlPanel,"South");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int count = Integer.parseInt(textField.getText());
                panel.setMeteorCount(count);
            }
            
        });
    }
     public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
    }
}


