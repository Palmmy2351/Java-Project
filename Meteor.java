// import java.awt.*;

// public class Meteor extends Thread {

//     Mypanel panel;
//     Image meteor;

//     int x;
//     int y;
//     int speed;

//     int dx;
//     int dy;

//     boolean running = true;

//     Meteor(Mypanel panel, Image meteor, int x, int y, int speed) {

//         this.panel = panel;
//         this.meteor = meteor;
//         this.x = x;
//         this.y = y;
//         this.speed = speed;

//         int[][] directions = {
//             {1, 0},
//             {-1, 0},
//             {0, 1},
//             {0, -1},
//             {1, 1},
//             {-1, 1},
//             {1, -1},
//             {-1, -1}
//         };

//         int direction = (int)(Math.random() * 8);

//         dx = directions[direction][0];
//         dy = directions[direction][1];
//     }

//     @Override
// public void run() {

//     while (running) {

//         x = x + dx * speed;
//         y = y + dy * speed;

//         // ชนขอบซ้าย/ขวา
//         if (x <= 0 || x >= panel.getWidth() - 50) {
//             dx = -dx;
//         }

//         // ชนขอบบน/ล่าง
//         if (y <= 0 || y >= panel.getHeight() - 50) {
//             dy = -dy;
//         }

//         // ตรวจชนกับอุกกาบาตลูกอื่น
//         if (running) {
//             panel.checkCollision(this);
//         }

//         panel.repaint();

//         try {
//             Thread.sleep(30);
//         } catch (InterruptedException e) {
//             Thread.currentThread().interrupt();
//             break;
//         }
//     }
// }
//     public void draw(Graphics g) {

//         if (running) {
//             g.drawImage(
//                 meteor,
//                 x,
//                 y,
//                 50,
//                 50,
//                 panel
//             );
//         }
//     }

//     public void explode() {
//         running = false;
//     }
// }
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

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 1},
            {-1, 1},
            {1, -1},
            {-1, -1}
        };

        int direction = (int)(Math.random() * directions.length);

        dx = directions[direction][0];
        dy = directions[direction][1];
    }

    @Override
    public void run() {

        while (running) {
<<<<<<< HEAD

            // ขยับทุกครั้ง
            x += dx * speed;
            y += dy * speed;

            // ชนขอบซ้าย / ขวา
            if (x <= 0) {
                x = 0;
                dx = 1;
            }

            if (x >= panel.getWidth() - 50) {
                x = panel.getWidth() - 50;
                dx = -1;
            }

            // ชนขอบบน / ล่าง
            if (y <= 0) {
                y = 0;
                dy = 1;
            }

            if (y >= panel.getHeight() - 50) {
                y = panel.getHeight() - 50;
                dy = -1;
            }

            // ตรวจการชน
            panel.checkCollision(this);

=======
            x = x + dx * speed; 
            y = y + dy * speed;
>>>>>>> 7308b9fe5c3494a0319d21aacd46b600c8616a8d
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
            g.drawImage(
                meteor,
                x,
                y,
                50,
                50,
                panel
            );
        }
    }

    public void explode() {
        running = false;
    }
}