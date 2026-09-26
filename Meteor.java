
import java.awt.*;
public class Meteor extends Thread{
    Mypanel panel;
    Image meteor;
    int x;
    int y;
    int speed;
    int dx;
    int dy;
    boolean running = true;

    Meteor(Mypanel panel, Image meteor, int x, int y, int speed) {
        this.panel = panel; 
        this.meteor = meteor;
        this.x = x;
        this.y = y;
        this.speed = speed;
<<<<<<< HEAD
        randomDirection();
    }
    public void randomDirection(){
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1},{1, 1},{-1, 1},{1, -1},{-1, -1}} ;
        int direction =(int)(Math.random()*8);
=======
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1},{1, 1},{-1, 1},{1, -1},{-1, -1}};
        int direction = (int)(Math.random() * 8);
>>>>>>> 8569f59114db755372a19fcdb9e78c6b580d8654
        dx = directions[direction][0];
        dy = directions[direction][1];

    }

    @Override
    public void run() {
        while (running) {
            x = x + dx* speed; 
            y = y + dy * speed;
<<<<<<< HEAD
            if (x <= 0) {
            x = 0;
            speed++;
            do {
                randomDirection();
            } while (dx < 0);
=======
            panel.repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                break;
>>>>>>> 8569f59114db755372a19fcdb9e78c6b580d8654
            }
        }
<<<<<<< HEAD

     public void draw(Graphics g) {
=======
    }
    public void draw(Graphics g) {
>>>>>>> 8569f59114db755372a19fcdb9e78c6b580d8654
        if (running) {
            g.drawImage(meteor, x, y, 50, 50, panel);
        }
    }
}