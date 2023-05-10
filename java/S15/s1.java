
class MyThread extends Thread
{
public void run() {
System.out.println("Thread name: " + getName());
System.out.println("Thread priority: " + getPriority());
}
}
public class s1 {
public static void main(String[] args) {
MyThread thread = new MyThread();
thread.setName("MyThread");
thread.setPriority(Thread.MAX_PRIORITY);
thread.start();
}
}