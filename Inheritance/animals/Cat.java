package Inheritance.animals;

public class Cat extends Animal {
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
        super.setSound("Meow meow");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
