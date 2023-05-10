
import java.util.Scanner;
import java.util.TreeSet;
public class s1 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
// Accept the number of integers to be entered
System.out.print("Enter the number of integers: ");
int n = sc.nextInt();
// Accept the integers and add them to a TreeSet
TreeSet<Integer> set = new TreeSet<Integer>();
System.out.print("Enter " + n + " integers: ");
for (int i = 0; i < n; i++) {
int num = sc.nextInt();
set.add(num);
}
// Display the sorted integers on the console
System.out.print("Sorted integers: ");
for (int num : set) {
System.out.print(num + " ");
}
sc.close();
}
}