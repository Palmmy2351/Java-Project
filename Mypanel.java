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
            if (meteors[i] != null) {
                meteors[i].draw(g);
            }
        }
        
    }

    public synchronized void checkCollision(Meteor current) {
        for (int i = 0; i < meteorCount; i++) {
            Meteor other = meteors[i];
            if (other == null || other == current) {
                continue;
            }
            if (!other.running || !current.running) {
                continue;
            }
            Rectangle currentRect = new Rectangle(current.x, current.y, 50, 50);

            Rectangle otherRect = new Rectangle(other.x, other.y, 50, 50);

            if (currentRect.intersects(otherRect)) {
                int currentIndex = -1;
                for (int j = 0; j < meteorCount; j++) {
                    if (meteors[j] == current) {
                        currentIndex = j;
                        break;
                    }
                }
                if (currentIndex < i) {
                    other.explode();
                }
                break;
            }
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

    public void checkCollision(Meteor meteor2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkCollision'");
    }
    public void checkCollision(Meteor meteor2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkCollision'");
    }