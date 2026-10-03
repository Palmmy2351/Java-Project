import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Mypanel extends JPanel {

    Image bg = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir") + File.separator + "background.jpg");

    Image meteor[];
    int meteorX[];
    int meteorY[];
    int meteorCount;
    Meteor meteors[];
    Image bomb;
    int bombX;
    int bombY;
    boolean showBomb = false;

    public void setMeteorCount(int count) {
        meteorCount = count;
        meteor = new Image[count];
        meteorX = new int[count];
        meteorY = new int[count];
        meteors = new Meteor[count];
        for (int i = 0; i < count; i++) {
            meteor[i] = randomImage();
            meteorX[i] = (int) (Math.random() * 640);
            meteorY[i] = (int) (Math.random() * 650);

            int speed = (int) (Math.random() * 5) + 1;

            meteors[i] = new Meteor(this, meteor[i], meteorX[i], meteorY[i], speed);
            meteors[i].start();
        }
        repaint();
    }

    Mypanel() {
        setSize(690, 800);
        bomb = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir") + File.separator + "bomb.gif" );
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);
        for (int i = 0; i < meteorCount; i++) {
            meteors[i].draw(g);
        }

        if (showBomb) {
        g.drawImage( bomb, bombX - 40, bombY - 40, 130,130, this);
        }
    }

    public Image randomImage() {
        int randomNum = (int) (Math.random() * 10) + 1;
        Image img = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir") + File.separator + randomNum + ".png");
        return img;
    }

    public synchronized void checkCollision(Meteor current) {
        if (!current.running) {
            return;
        }
        for (int i = 0; i < meteors.length; i++) {
            Meteor other = meteors[i];
            if (other == null) {
                continue;
            }
            if (other == current) {
                continue;
            }
            if (!other.running) {
                continue;
            }
            int distanceX = current.x - other.x;
            int distanceY = current.y - other.y;
            int distance = distanceX * distanceX + distanceY * distanceY;

            // ชนกัน
            if (distance <= 50 * 50) {
                // แสดงระเบิดตรงจุดชน
                bombX = (current.x + other.x) / 2;
                bombY = (current.y + other.y) / 2;
                showBomb = true;

                repaint();

                // สุ่มให้อุกกาบาตหาย 1 ลูก
                if (Math.random() < 0.5) {
                    current.explode();
                } else {

                    other.explode();
                }
                // แสดง bomb 0.5 วินาที
                new Thread(() -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {}
                    showBomb = false;
                    repaint();
                }).start();
                return;
            }
        }
    }
}
