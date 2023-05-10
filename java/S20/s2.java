import java.awt.*;
import javax.swing.*;

public class s2 extends JFrame implements Runnable {
    private ImageIcon imageIcon;
    private JLabel label;

    public s2() {
        imageIcon = new ImageIcon("/home/eternity/image.png");
        label = new JLabel(imageIcon);
        getContentPane().add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(500); // sleep for half a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            label.setVisible(!label.isVisible());
        }
    }

    public static void main(String[] args) {
        new s2();
    }
}