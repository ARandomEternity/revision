
import java.sql.*;
public class s2
{
public static void main(String args[]) throws Exception
{
Class.forName("org.postgresql.Driver");
Connection con =
DriverManager.getConnection("jdbc:postgresql://localhost:5432/teacher","postgres","123")
;
Statement
stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
ResultSet rs= stmt.executeQuery("select * from teacher1");
rs.last();
rs.beforeFirst();
System.out.println("Teacher Details:");
System.out.println("==================================");
while(rs.next())
{
int tid = rs.getInt("tid");
String tname=rs.getString("tname");
double salary = rs.getDouble("salary");
System.out.println("TID : "+tid);
System.out.println("Teacher name : "+tname);
System.out.println("Teacher Salary : "+salary);
}
con.close();
}
}