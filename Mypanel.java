import java.awt.*;
import java.io.*;
import javax.swing.*;


public class Mypanel extends JPanel{
    Image bg = Toolkit.getDefaultToolkit().createImage(
        System.getProperty("user.dir") + File.separator + "background.jpg" 
    );
    Image meteor = randomImage();
    Mypanel() {
        setSize(690, 800);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);
        g.drawImage(meteor, 100, 100,50, 50, this);
    }
    // Method to generate a random image for the meteor
    public Image randomImage() {
        int randomNum = (int)(Math.random() * 10) + 1;
        Image img = Toolkit.getDefaultToolkit().createImage(
            System.getProperty("user.dir") + File.separator + randomNum + ".png"
        );
        return img;
       
    }
}