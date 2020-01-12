package Inheritance.RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList list = new RandomArrayList();

        list.add(4);
        list.add(4444);
        list.add(544545);

        System.out.println(list.getRandomElement(list));
    }
}
