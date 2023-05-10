
//. Write a java program to define a thread for printing text on output screen for ‘n’ number of
//times. Create 3 threads and run them. Pass the text ‘n’ parameters to the thread constructor.
//Example:
//i. First thread prints “COVID19” 10 times.
//ii. Second thread prints “LOCKDOWN2020” 20 times
//iii. Third thread prints “VACCINATED2021” 30 times
import java.io.*;
import java.util.*;
import java.lang.*;

public class s1 extends Thread {
    String m;
    int n;

    s1(String m, int n) {
        this.m = m;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(m);
        }
    }

    public static void main(String args[]) {
        s1 b1 = new s1("Covid19", 10);
        s1 b2 = new s1("Lockdown2020", 20);
        s1 b3 = new s1("Vaccinated", 30);
        b1.start();
        b2.start();
        b3.start();
    }
}