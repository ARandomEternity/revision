import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;

class emp1 extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField tf1, tf2, tf3, tf4;
    JButton b1, b2;
    Connection con;

public emp1()
{
l1=new JLabel("Eno");
l2=new JLabel("Ename");
l3=new JLabel("Designation");
l4=new JLabel("Salary");
tf1=new JTextField();
tf2=new JTextField();
tf3=new JTextField();
tf4=new JTextField();
b1=new JButton("Save");
b2=new JButton("Reset");
l1.setBounds(80, 70,200,30);
l2.setBounds(80, 120,200,30);
l3.setBounds(80, 150,200,30);
l4.setBounds(80, 190,200,30);
tf1.setBounds(300,70,200,30);
tf2.setBounds(300, 120,200,30);
tf3.setBounds(300, 150,200,30);
tf4.setBounds(300, 190,200,30);
b1.setBounds(50,250,100,30);
b1.setBounds(170,250,100,30);
add(l1);
add(tf1);
add(l2);
add(tf2);
add(l3);
add(tf3);
add(l4);
add(tf4);
add(b1);
add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
setSize(600,400);
setLayout(null);
setVisible(true);
try
{
Class.forName("org.postgresql.Driver"); 
con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/emp","postgres","postgres");
}catch(Exception e)
{
e.printStackTrace();
}
}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                String eno = tf1.getText();
                String ename = tf2.getText();
                String desig = tf3.getText();
                String sal = tf4.getText();
                String sql = "insert into empl values(" + eno + ",'" + ename + "','" + desig + "'," + sal + ")";
                Statement smt = con.createStatement();
                int i = smt.executeUpdate(sql);
                if (i > 0) {
                    JOptionPane.showMessageDialog(this, "Record Save Sucessfully");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Error in saving record.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
        }
    }

    public static void main(String args[]) {
        new emp1();
    }
}