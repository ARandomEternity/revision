import java.sql.*;

public class s2 {
    public static void main(String args[]) {
        Connection con;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teach", "postgres", "postgres");
            if (con == null) {
                System.out.println("Connection Failed....");
                System.exit(1);
            }
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * From teacher Where subje='java'");
            System.out.println("teachno\t" + "teachname\t" + "subje");
            while (rs.next()) {
                System.out.println("\n" + rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
            con.close();
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}