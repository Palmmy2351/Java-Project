import javax.swing.*;
public class MyFrame extends JFrame {
    MyFrame() {
        setTitle("My Frame");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("background.jpg");
        JLabel background = new JLabel(icon);
        
        background.setBounds(0, 0, 700, 800);
        add(background);
        
        setVisible(true);
    }
}
    

