
import java.util.*;
public class s1 {
public static void main(String[] args) {
TreeSet<String> colors = new TreeSet<String>();
colors.add("Red");
colors.add("Green");
colors.add("Blue");
colors.add("Yellow");
System.out.println("Colors in ascending order:");
for (String color : colors) {
System.out.println(color);
}
}
}