import java.awt.*;
import java.io.*;
import javax.swing.*;

public class MyPanel extends JPanel{
    Image bg = Toolkit.getDefaultToolkit().createImage(
        System.getProperty("user.dir") + File.separator + "background.jpg" 
    );

    MyPanel() {
        setSize(690, 800);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);
    }     
}
