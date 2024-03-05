// Person.java
class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final int age;
    private final String address;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.age = builder.age;
        this.address = builder.address;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        // Required parameters
        private final String firstName;
        private final String lastName;

        // Optional parameters - initialized to default values
        private String middleName = "";
        private int age = 0;
        private String address = "";

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}


public class Builder_Pattern {
    public static void main(String[] args) {
        // Creating a person with required parameters
        Person person1 = new Person.Builder("John", "Doe").build();

        // Creating a person with required and optional parameters
        Person person2 = new Person.Builder("Jane", "Smith")
                .middleName("Anne")
                .age(30)
                .address("123 Main St, Anytown")
                .build();

        // Accessing individual getter methods
        System.out.println(person1);
        System.out.println("Person 1:");
        System.out.println("First Name: " + person1.getFirstName());
        System.out.println("Last Name: " + person1.getLastName());
        System.out.println("Middle Name: " + person1.getMiddleName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Address: " + person1.getAddress());
        
        System.out.println(person2);
        System.out.println("\nPerson 2:");
        System.out.println("First Name: " + person2.getFirstName());
        System.out.println("Last Name: " + person2.getLastName());
        System.out.println("Middle Name: " + person2.getMiddleName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Address: " + person2.getAddress());
    }
}
