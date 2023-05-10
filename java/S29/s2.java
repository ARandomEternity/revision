
import java.util.LinkedList;
public class s2 {
public static void main(String[] args) {
// Creating a LinkedList of integers
LinkedList<Integer> list = new LinkedList<>();
// Adding elements to the LinkedList
list.add(10);
list.add(20);
list.add(30);
// Adding element at the first position
list.addFirst(5);
// Deleting the last element
list.removeLast();
// Displaying the size of LinkedList
System.out.println("Size of LinkedList: " + list.size());
// Displaying the elements of LinkedList
System.out.println("Elements of LinkedList: " + list);
}
}