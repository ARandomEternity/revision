public class s1 {
    public static void main(String[] args) {
        char ch;
        for (ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
            try {
                Thread.sleep(2000); // Wait for 2 seconds before printing the next character
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}