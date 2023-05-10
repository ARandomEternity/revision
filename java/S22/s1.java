
import java.sql.*;
import java.util.*;

public class s1 {
    public static void main(String args[]) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "123");
        Statement stmt = con.createStatement();
        int ch;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Employee Management System");
            System.out.println("----------------------------");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Employee Number :");
                    int eno = sc.nextInt();
                    System.out.println("Enter Employee Name");
                    String name = sc.next();
                    System.out.println("Enter Employee Salary");
                    int salary = sc.nextInt();
                    String query = "insert into employe values(" + eno + ",'" + name + "'," + salary + ")";
                    stmt.executeUpdate(query);
                    System.out.println("Data entered sucessfull");
                    break;
                case 2:
                    System.out.println("Enter Employee Number :");
                    eno = sc.nextInt();
                    System.out.println("Enter new Employee Name");
                    name = sc.next();
                    System.out.println("Enter new Employee Salary");
                    salary = sc.nextInt();
                    query = "update employe set name='" + name + "',salary=" + salary + " where no=" + eno + "";
                    int row = stmt.executeUpdate(query);
                    if (row > 0) {
                        System.out.println("Data Updated Sucessfully!!");
                    } else {
                        System.out.println("Data not Updated");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Employee Details ---");
                    String selectQuery = "SELECT * FROM employe";
                    ResultSet rs = stmt.executeQuery(selectQuery);
                    System.out.println("ENo\tEName\t\tSalary");
                    System.out.println("---------------------------------");
                    while (rs.next()) {
                        int eNo = rs.getInt("no");
                        String eName = rs.getString("name");
                        double empSalary = rs.getDouble("salary");
                        System.out.println(eNo + "\t" + eName + "\t\t" +
                                empSalary);
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
            }
        } while (ch <= 4);
    }
}