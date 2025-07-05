import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        System.out.println("Enter details for 5 people:");
        for (int i = 0; i < 5; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            queue.enqueue(new Person(firstName, lastName, age));
        }

        System.out.println("\n--- Original Queue ---");
        queue.display();

        System.out.println("\n--- Queue Sorted by Last Name (Descending) ---");
        queue.sortByLastNameDesc();
        queue.display();

        System.out.println("\n--- Queue Sorted by Age (Descending) ---");
        queue.sortByAgeDesc();
        queue.display();
    }
}
