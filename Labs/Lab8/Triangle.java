public class Triangle extends GeometricObject{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(){
        side1 = 0.0;
        side2 = 0.0;
        side3 = 0.0;
    }

    public Triangle(double side1, double side2, double side3){
        if (side1 < 0 || side2 < 0 || side3 < 0){
            throw new IllegalArgumentException("Sides can't be less than 0");
        }
        else{
            this.side1 = side1;
            this.side2 = side2;        
            this.side3 = side3;  
        }
    }

    public void setSide1(double side1){
        if (side1 < 0)
            throw new IllegalArgumentException("Sides can't be less than 0");
        else
            this.side1 = side1;
    }

    public void setSide2(double side2){
        if (side2 < 0)
            throw new IllegalArgumentException("Sides can't be less than 0");
        else
            this.side2 = side2;    
    }

    public void setSide3(double side3){
        if (side3 < 0)
            throw new IllegalArgumentException("Sides can't be less than 0");
        else
            this.side3 = side3;
    }

    public double getSide1(){
        return side1;
    }

    public double getSide2(){
        return side2;
    }

    public double getSide3(){
        return side3;
    }

    @Override
    public double getArea(){
        double halfPerimeter = (getPerimeter()) / 2;
        return Math.round((Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3)) * 100.0)) / 100.0; //Computes Area and rounds to two decimal places
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    public boolean isEquilateral(){
        return ((side1 == side2) && (side2 == side3));
    }

    public boolean isIsosceles(){
        return (((side1 == side2) || (side1 == side3) || (side2 == side3)) && (!isEquilateral()));
    }

    public boolean isScalene(){
        return (!isEquilateral() && !isIsosceles());
    }

    public String toString(){
        return super.toString() + " Side 1: " + side1 + " Side 2: " + side2 + " and Side 3: " + side3;
    }

}
