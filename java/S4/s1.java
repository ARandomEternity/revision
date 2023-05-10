
//1.Write a Java program using Runnable interface to blink Text on the frame.
import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class s1 implements Runnable {
    private JLabel label;

    public s1(JLabel label) {
        this.label = label;
    }
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000); // wait for 1 second
                label.setVisible(!label.isVisible()); // toggle the visibility of the label
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Blinking Text");
        JLabel label = new JLabel("Blinking Text");
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
        s1 blinkingText = new s1(label);
        Thread thread = new Thread(blinkingText);
        thread.start();
    }
}