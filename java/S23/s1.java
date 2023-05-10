
import java.util.Scanner;
public class s1 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a string: ");
String str = scanner.nextLine().toLowerCase();
for (int i = 0; i < str.length(); i++) {
char ch = str.charAt(i);
if (isVowel(ch)) {
System.out.println(ch);
try {
Thread.sleep(3000); // sleep for 3 seconds
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}
private static boolean isVowel(char ch) {
return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
}
}