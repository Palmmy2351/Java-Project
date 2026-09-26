import java.awt.*;
public class Meteor extends Thread{
    Mypanel panel;
    Image meteor;
    int x;
    int y;
    int speed;
    boolean running = true;

    Meteor(Mypanel panel, Image meteor, int x, int y, int speed) {
        this.panel = panel; 
        this.meteor = meteor;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    @Override
    public void run() {
        while (running) {
            x = x + speed; 
            y = y + speed;
            
            panel.repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
     public void draw(Graphics g) {
        if (running) {
            g.drawImage(meteor, x, y, 50, 50, panel);
        }
    }
}
