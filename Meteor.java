import java.awt.*;

public class Meteor extends Thread {
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
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1},{1, 1},{-1, 1},{1, -1},{-1, -1}};
        int direction = (int)(Math.random() * directions.length);
        dx = directions[direction][0];
        dy = directions[direction][1];
    }

    @Override
    public void run() {
        while (running) {
            x = x + dx * speed;
            y = y + dy * speed;
            panel.repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    public void draw(Graphics g) {
        if (running) {
            g.drawImage(meteor,x,y,50,50,panel);
        }
    }
}