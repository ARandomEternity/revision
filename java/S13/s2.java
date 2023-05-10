import java.util.Random;
public class s2 implements Runnable {
private String threadName;
private Thread thread;
public s2(String name) {
threadName = name;
System.out.println("Creating " + threadName);
}
public void run() {
System.out.println("Running " + threadName);
Random random = new Random();
try {
for (int i = 1; i <= 5; i++) {
System.out.println(threadName + ": " + i);
int sleepTime = random.nextInt(5000);
System.out.println(threadName + " sleep for " + sleepTime + "milliseconds");
Thread.sleep(sleepTime);
}
} catch (InterruptedException e) {
System.out.println("Thread " + threadName + " interrupted.");
}
System.out.println("Thread " + threadName + " exiting.");
}
public void start() {
System.out.println("Starting " + threadName);
if (thread == null) {
thread = new Thread(this, threadName);
thread.start();
}
}
public static void main(String args[]) {
s2 thread1 = new s2("Thread 1");
thread1.start();
s2 thread2 = new s2("Thread 2");
thread2.start();
}
}