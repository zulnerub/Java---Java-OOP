package Inheritance.animals;

public class Kitten extends Cat {
    private static final String GENDER = "Female";
    public Kitten(String name, int age) {
        super(name, age, GENDER);
        super.setSound("Meow");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
