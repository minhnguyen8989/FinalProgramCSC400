import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Queue {
    private List<Person> people;

    public Queue() {
        people = new ArrayList<>();
    }

    public void enqueue(Person person) {
        people.add(person);
    }

    public void display() {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public void sortByLastNameDesc() {
        quickSort(0, people.size() - 1, Comparator.comparing(Person::getLastName).reversed());
    }

    public void sortByAgeDesc() {
        quickSort(0, people.size() - 1, Comparator.comparingInt(Person::getAge).reversed());
    }

    private void quickSort(int low, int high, Comparator<Person> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quickSort(low, pi - 1, comparator);
            quickSort(pi + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<Person> comparator) {
        Person pivot = people.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(people.get(j), pivot) <= 0) {
                i++;
                Collections.swap(people, i, j);
            }
        }

        Collections.swap(people, i + 1, high);
        return i + 1;
    }
}
