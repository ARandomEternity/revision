
class s1 extends Thread {
    String msg[] = { "Java", "Supports", "Multithreading", "Concept" };

    s1(String name) {
        super(name);
    }

    public void run() {
        display(getName());
        System.out.println("Exit from " + getName());
    }

    synchronized void display(String name) // Synchrinized method
    {
        for (int i = 0; i < msg.length; i++) {
            System.out.println(name + msg[i]);
        }
    }
}

class MySynchro {
    public static void main(String args[]) {
        s1 t1 = new s1("Thread 1: ");
        s1 t2 = new s1("Thread 2: ");
        t1.start();
        t2.start();
        System.out.println("Main thread exited");
    }
}