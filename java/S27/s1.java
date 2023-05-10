
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class s1 {
public static void main(String[] args) {
try{
Connection con =
DriverManager.getConnection("jdbc:postgresql://localhost:5432/collage","postgres","123");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from clg");
// Create the table model and add column names
DefaultTableModel tm = new DefaultTableModel();
tm.addColumn("CID");
tm.addColumn("CName");
tm.addColumn("Address");
tm.addColumn("Year");
// Add rows from the result set to the table model
while (rs.next()) {
int cid = rs.getInt("cid");
String cname = rs.getString("cname");
String address = rs.getString("address");
int year = rs.getInt("year");
tm.addRow(new Object[]{cid, cname, address, year});
}
// Create the JTable and set the table model
JTable table = new JTable(tm);
// Create the scroll pane and add the table to it
JScrollPane scrollPane = new JScrollPane(table);
// Create the frame and add the scroll pane to it
JFrame frame = new JFrame("College Details");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new BorderLayout());
frame.add(scrollPane, BorderLayout.CENTER);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);
con.close();
}catch(Exception e)
{
e.printStackTrace();
}
}
}