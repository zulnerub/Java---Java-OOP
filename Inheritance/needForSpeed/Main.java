package Inheritance.needForSpeed;

public class Main {
    public static void main(String[] args) {
        SportCar car = new SportCar(9, 150);

        car.drive(1);
        System.out.println(car.getFuel());
    }
}
