package Inheritance.CustomStack;

import java.util.ArrayList;


public class Stack extends ArrayList<String> {

    private ArrayList<String> data;

    public Stack(){
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        return this.data.remove(this.data.size() - 1);
    }

    public String peek(){
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty(){
        return this.data.size() < 1;
    }
}
