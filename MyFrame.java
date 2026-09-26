import javax.swing.*;
public class MyFrame extends JFrame {
    MyFrame() {
        setSize(690, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
     public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.add(new Mypanel());
        frame.setVisible(true);
    }
}


