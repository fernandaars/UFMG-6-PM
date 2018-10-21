package at2;

public class TestCircle {
    public static void main(String[ ] args) {
        Circle c1 = new Circle();
        System.out.println( "O circulo tem o raio de " + c1.getRadius() + " e area de " + c1.getArea() );   
        
        Circle c2 = new Circle(2.0);
        System.out.println( "O circulo tem raio de " + c2.getRadius() + " e area de " + c2.getArea() );
    }
} 

