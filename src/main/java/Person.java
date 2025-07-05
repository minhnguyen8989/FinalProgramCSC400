/**
 * Represents a person with a first name, last name, and age.
 * <p>
 * Provides access to the last name and age, as well as a string
 * representation of the person.
 * </p>
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    /**
     * Constructs a new {@code Person} with the specified first name, last name, and age.
     *
     * @param firstName the person's first name
     * @param lastName  the person's last name
     * @param age       the person's age
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Returns the last name of the person.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the age of the person.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns a string representation of the person, including their full name and age.
     *
     * @return a string in the format "FirstName LastName - Age: X"
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " - Age: " + age;
    }
}
