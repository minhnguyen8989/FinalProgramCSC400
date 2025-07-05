import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * A custom queue implementation that stores {@link Person} objects.
 * <p>
 * Provides basic queue functionality like enqueueing people,
 * displaying the queue, and sorting it by different criteria
 * using a custom implementation of the QuickSort algorithm.
 * </p>
 */
public class Queue {
    private List<Person> people;

    /**
     * Constructs an empty {@code Queue}.
     */
    public Queue() {
        people = new ArrayList<>();
    }

    /**
     * Adds a {@link Person} to the end of the queue.
     *
     * @param person the person to enqueue
     */
    public void enqueue(Person person) {
        people.add(person);
    }

    /**
     * Displays all people currently in the queue by printing
     */
    public void display() {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    /**
     * Sorts the people in the queue by last name in descending order
     */
    public void sortByLastNameDesc() {
        quickSort(0, people.size() - 1, Comparator.comparing(Person::getLastName).reversed());
    }

    /**
     * Sorts the people in the queue by age in descending order
     */
    public void sortByAgeDesc() {
        quickSort(0, people.size() - 1, Comparator.comparingInt(Person::getAge).reversed());
    }

    /**
     * Recursively applies QuickSort to sort a sublist of {@code people}
     * using the specified comparator.
     *
     * @param low        the starting index of the sublist
     * @param high       the ending index of the sublist
     * @param comparator the comparator defining the sort order
     */
    private void quickSort(int low, int high, Comparator<Person> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quickSort(low, pi - 1, comparator);
            quickSort(pi + 1, high, comparator);
        }
    }

    /**
     * Partitions the sublist of {@code people} between indices {@code low} and {@code high}
     * using the specified comparator and returns the pivot index.
     *
     * @param low        the starting index of the sublist
     * @param high       the ending index of the sublist
     * @param comparator the comparator used to compare elements
     * @return the index of the pivot element after partitioning
     */
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
