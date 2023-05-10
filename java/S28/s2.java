
public class s2 implements Runnable {
public void run() {
System.out.println("Currently executing thread: "
+Thread.currentThread().getName());
}
public static void main(String[] args) {
// Creating 3 threads
Thread t1 = new Thread(new s2());
Thread t2 = new Thread(new s2());
Thread t3 = new Thread(new s2());
// Starting the threads
t1.start();
t2.start();
t3.start();
}
}