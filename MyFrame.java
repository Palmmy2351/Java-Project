import javax.swing.*;
import java.awt.*;
import java.io.*;
public class MyFrame extends JFrame {
    MyFrame() {
        setSize(690, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
     public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.add(new MyPanel());
        frame.setVisible(true);
    }
}
 class MyPanel extends JPanel {
    Image bg = Toolkit.getDefaultToolkit().createImage(
        System.getProperty("user.dir") + File.separator + "background.jpg" 
    );

    MyPanel() {
        setSize(690, 800);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);
    }     
 }

