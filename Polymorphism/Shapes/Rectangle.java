package Polymorphism.Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;


    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public void calculatePerimeter() {
        Double result =  (this.getWidth() + this.getHeight()) * 2;
        super.setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        Double result =  this.getWidth() * this.getHeight();
        super.setArea(result);
    }
}
