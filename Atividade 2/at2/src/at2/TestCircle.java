package at2;

public class TestCircle {
    static Circle c1;
    static Circle c2;
    static Circle c3;
    public static void main(String[ ] args) {
        
        TestCircle.c3 = new Circle();
        c3.setColor("Rosa");
        System.out.println(c3.toString());
        
        TestCircle.c1 = new Circle(5.0);
        System.out.println(c1.toString());

        TestCircle.c2 = new Circle(1.2);
        System.out.println(c2.toString());
        System.out.println(c2);
        System.out.println("Aqui o operador '+' também invoca toString(): " + c2);
        
    }
} 

