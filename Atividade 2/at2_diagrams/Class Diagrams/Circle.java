
package at2;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        radius = 1.0;
        color = "red";
    }

    public Circle(double radius) {
        this( );
        this.radius = radius;
    }
    
    public Circle(String color) {
        this( );
        this.color = color;
    }
    
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }
    
    public String getColor() {
        return this.color;
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }
}
