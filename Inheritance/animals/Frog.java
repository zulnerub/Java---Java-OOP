package Inheritance.animals;

public class Frog extends Animal {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
        super.setSound("Ribbit");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
