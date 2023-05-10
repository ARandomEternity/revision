
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class s2 implements Runnable, ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JButton startButton, stopButton;
    private boolean running;

    public s2() {
        frame = new JFrame("Number Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField = new JTextField(10);
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(startButton);
        panel.add(stopButton);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public void run() {
        int i = 1;
        while (running) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textField.setText(Integer.toString(i));
            i++;
            if (i > 100) {
                i = 1;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!running) {
                running = true;
                Thread thread = new Thread(this);
                thread.start();
            }
        } else if (e.getSource() == stopButton) {
            running = false;
        }
    }

    public static void main(String[] args) {
        new s2();
    }
}