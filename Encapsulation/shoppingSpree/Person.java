package Encapsulation.shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {


        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.contains("\\W+")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {

        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }



    public void buyProduct(Product product){
        if (product.getCost() > this.money){
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
        this.products.add(product);
        this.money -= product.getCost();
        System.out.printf("%s bought %s%n", this.name, product.getName());
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");

        if (this.products.isEmpty()) {
            sb.append("Nothing bought");
        }else{
            this.products.forEach(e -> sb.append(e.getName()).append(", "));
          return sb.toString().trim().substring(0, sb.length() - 2);
        }

        return sb.toString();

    }
}
