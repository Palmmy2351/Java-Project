import java.awt.*;
import java.io.*;
import javax.swing.*;


public class Mypanel extends JPanel{
    Image bg = Toolkit.getDefaultToolkit().createImage(
        System.getProperty("user.dir") + File.separator + "background.jpg" 
    );
    Image meteor [] ;
    int meteorX [];
    int meteorY [];
    int meteorCount;
    Meteor meteors[];

    public void setMeteorCount(int count){
        meteorCount = count;
        meteor = new Image[count];
        meteorX = new int[count];
        meteorY = new int[count];
        meteors = new Meteor[count];
        for (int i = 0; i < count; i++) {
            meteor[i] = randomImage();
            meteorX[i] = (int)(Math.random()*640);
            meteorY[i] = (int)(Math.random()*650);

            int speed = (int)(Math.random()* 5)+1;

            meteors[i] = new Meteor(this,meteor[i],meteorX[i],meteorY[i],speed);

            meteors[i].start();
        }
        repaint();
    }

    Mypanel() {
        setSize(690, 800);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);
        for (int i = 0; i < meteorCount; i++) {
            meteors[i].draw(g);
        }
        
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