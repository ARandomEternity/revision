
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
public class s2 {
public static void main(String[] args) {
ArrayList<String> studentNames = new ArrayList<>();
// Adding student names to ArrayList
for (int i = 0; i < args.length; i++) {
studentNames.add(args[i]);
}
// Displaying student names using Iterator interface
System.out.println("Displaying student names using Iterator interface:");
Iterator<String> iterator = studentNames.iterator();
while (iterator.hasNext()) {
System.out.println(iterator.next());
}
// Displaying student names using ListIterator interface
System.out.println("\nDisplaying student names using ListIterator interface:");
ListIterator<String> listIterator = studentNames.listIterator();
while (listIterator.hasNext()) {
System.out.println(listIterator.next());
}
}
}