package Polymorphism.Animals;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Oskar", "chushki");
        Dog dog = new Dog("penka", "drojdi");
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
