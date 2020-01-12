package Inheritance.animals;

public class Dog extends Animal {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
        super.setSound("Woof!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
