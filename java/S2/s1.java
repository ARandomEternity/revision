
import java.util.*;
public class s1 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Set<String> friends = new HashSet<String>();
int n;
System.out.print("Enter the number of friends: ");
n = sc.nextInt();
for (int i = 1; i <= n; i++) {
System.out.print("Enter the name of friend " + i + ": ");
String name = sc.next();
friends.add(name);
}
List<String> friendsList = new ArrayList<String>(friends);
Collections.sort(friendsList);
System.out.println("The list of friends in ascending order:");
for (String friend : friendsList) {
System.out.println(friend);
}
}
}