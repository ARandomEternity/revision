

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class s2 {
    public static void main(String[] args) {
        Map<String, String> cityCodes = new HashMap<String, String>();
        // Add some initial cities and codes
        cityCodes.put("Mumbai", "022");
        cityCodes.put("Delhi", "011");
        cityCodes.put("Chennai", "044");
        cityCodes.put("Kolkata", "033");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add a new city and its code");
            System.out.println("2. Remove a city");
            System.out.println("3. Search for a city name and display the code");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the city name: ");
                    String city = sc.next();
                    System.out.print("Enter the STD code: ");
                    String code = sc.next();
                    if (cityCodes.containsKey(city)) {
                        System.out.println(city + " already exists in the list.");
                    } else {
                        cityCodes.put(city, code);
                        System.out.println(city + " has been added to the list.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the city name: ");
                    String cityToRemove = sc.next();
                    if (cityCodes.containsKey(cityToRemove)) {
                        cityCodes.remove(cityToRemove);
                        System.out.println(cityToRemove + " has been removed from the list.");
                    } else {
                        System.out.println(cityToRemove + " does not exist in the list.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the city name: ");
                    String cityToSearch = sc.next();
                    if (cityCodes.containsKey(cityToSearch)) {
                        System.out.println("The STD code for " + cityToSearch + " is " +
                                cityCodes.get(cityToSearch));
                    } else {
                        System.out.println(cityToSearch + " does not exist in the list.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }
    }
}