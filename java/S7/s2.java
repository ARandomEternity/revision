
/*2. Write a java program for the following: i. To create a Product(Pid, Pname, Price)
table. ii. Insert at least five records into the table. iii. Display all the records from a
table.*/
import java.sql.*;
import java.util.*;

public class s2 {
public static void main(String args[])
{
Connection con;
Scanner sc=new Scanner(System.in);
try{
Class.forName("org.postgresql.Driver");
con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/product"
,"postgres", "postgres");
System.out.println("Enter product id:");
int pid=sc.nextInt();
System.out.println("Enter product name:");
String pname=sc.next();
System.out.println("Enter price:");
int price=sc.nextInt();
Statement stmt=con.createStatement();
int i=stmt.executeUpdate("insert into pro values("+pid+",'"+pname+"',"+price+");");
con.close();
stmt.close();
}
catch(Exception e)
{
System.out.println(e);
}}
}

/*Database::-

sudo su-postgres[sudo]password for ritu:postgres@ritu-VirtualBox:~$ psql

psql (14.7 (Ubuntu 14.7-0ubuntu0.22.04.1))
Type "help" for help.
postgres=# create database product;
CREATE DATABASE
postgres=# \c
You are now connected to database "postgres" as user "postgres".
postgres=# \c product
You are now connected to database "product" as user "postgres".
product=# create table pro(pid int ,pname varchar(20),price int);
CREATE TABLE
product=# select * from pro;
pid | pname | price
-----+-------+-------
(0 rows)
product=# select * from pro;
pid | pname | price
-----+-------+-------
(0 rows)
product=# select * from pro;
pid | pname | price
-----+-------+-------
4 | ersss | 455*/