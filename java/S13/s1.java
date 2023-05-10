
import java.sql.*;

public class s1 {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/emp", "postgres",
                "postgres");
        DatabaseMetaData metaData = con.getMetaData();
        // Display information about the database
        System.out.println("Database Name: " + metaData.getDatabaseProductName());
        System.out.println("Database Version: " +
                metaData.getDatabaseProductVersion());
        System.out.println("Driver Name: " + metaData.getDriverName());
        System.out.println("Driver Version: " + metaData.getDriverVersion());
        System.out.println("\nTables:");
        ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE" });
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            System.out.println(tableName);
        }
        con.close();
    }
}