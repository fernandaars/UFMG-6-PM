
package at2;

public class Triangle {
    private double[] sides;
    private Point verticeA;
    private Point verticeB;
    private Point verticeC;
    private String type;

    public Triangle() {
        this.sides = new double[3];
        this.verticeA = new Point();
        this.verticeB = new Point();
        this.verticeC = new Point();
        this.sides[0] = 1;
        this.sides[1] = 1;
        this.sides[2] = 1;
        
        this.type = this.typeOfTriangle();
        
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sides = new double[3];
        
        this.sides[0] = sideA;
        this.sides[1] = sideB;
        this.sides[2] = sideC;
        this.type = this.typeOfTriangle();
    }

    public Triangle(Point verticeA, Point verticeB, Point verticeC) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.verticeC = verticeC;
        this.type = "Não é Possível Definir Tipo";
    }
    
    public double getPerimeter(){
        return this.sides[0]+this.sides[1]+this.sides[2];  
    }
    
    public double getArea(){
        double p = this.getPerimeter();
        p = p/2;
        p = p*(p-this.sides[0])*(p-this.sides[1])*(p-this.sides[2]);
        p = Math.sqrt(p);
        return p;
    }
    
    public String typeOfTriangle(){
        if((this.sides[0] == this.sides[1] || this.sides[1] == this.sides[2]) 
                || (this.sides[0] == this.sides[2])){
            if(this.sides[0] == this.sides[1] && this.sides[1] == this.sides[2]){
                return "Equilátero";
            }
            return "Isósceles";
        }
        return "Escaleno";
    }

    @Override
    public String toString() {
        return "Triangle{" + "sides=" + sides + ", verticeA=" + verticeA + ", verticeB=" + verticeB + ", verticeC=" + verticeC + ", type=" + type + '}';
    }
}
