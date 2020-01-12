package Polymorphism.Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5.00, 5.00);
        Shape circle = new Circle(5.00);
        rectangle.calculateArea();
        rectangle.calculatePerimeter();
        circle.calculatePerimeter();
        circle.calculateArea();
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
