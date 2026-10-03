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

        randomDirection();
    }
    public void randomDirection(){
        int direction =(int)(Math.random()*8);
        if(direction == 0){
            dx = 1;
            dy = 0;
        }else if(direction == 1){
            dx = 1;
            dy = 1;
        }else if(direction == 2){
            dx = 0;
            dy = 1;
        }else if(direction == 3){
            dx = -1;
            dy = 1;
        }else if(direction == 4){
            dx = -1;
            dy = 0;
        }else if(direction == 5){
            dx = -1;
            dy = -1;
        }else if(direction == 6){
            dx = 0;
            dy = -1;
        }else if(direction == 7){
            dx = 1;
            dy = -1;
        }
    }

    public void run() {
        while (running) {
            x = x + dx * speed;
            y = y + dy * speed;

            if (x <= 0) {
                x = 0;
                speed++;
                do {
                    randomDirection();
                } while (dx < 0);
            }
            if (x >= 640) {
                x = 640;
                speed++;
                do {
                    randomDirection();
                } while (dx > 0);
            }
            if (y <= 0) {
                y = 0;
                speed++;
                do {
                    randomDirection();
                } while (dy < 0);
            }
            if (y >= 750) {
                y = 750;
                speed++;
                do {
                    randomDirection();
                } while (dy > 0);
            }
            // เพิ่มบรรทัดนี้
            panel.checkCollision(this);
            panel.repaint();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    public void explode() {
        running = false;
        interrupt();
        panel.repaint();
    }
     public void draw(Graphics g) {
        if (running) {
            g.drawImage(meteor, x, y, 50, 50, panel);
        }
    }
}