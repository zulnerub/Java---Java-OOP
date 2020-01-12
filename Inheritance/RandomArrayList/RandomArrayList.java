package Inheritance.RandomArrayList;


import java.util.ArrayList;
import java.util.Random;


public class RandomArrayList<T> extends ArrayList{
    public ArrayList<T> list;

    public RandomArrayList() {
        this.list = new ArrayList<>();
    }

    public T getRandomElement(RandomArrayList list){
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return (T) list.remove(index);

    }
}
