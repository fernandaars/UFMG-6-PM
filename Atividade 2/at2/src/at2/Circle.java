
package at2;

public class Circle extends Point {
    
    private double radius;
    private String color;
    
    public Circle() {
        super();
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
        this();
        this.radius = radius;
        this.color = color;
    }
    
    public Circle(double radius, String color, float x, float y) {
        super(x,y);
        this.radius = radius;
        this.color = color;
    }
    
    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }
    
    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + ", color=" + color + '}';
    }
}
