public class Rectangle extends GeometricObject{
    private double side1;
    private double side2;
    
    public Rectangle(){
        side1 = 0.0;
        side2 = 0.0;
    }

    public Rectangle(double side1, double side2){
        if (side1 < 0 || side2 < 0){
            throw new IllegalArgumentException("Sides can't be less than 0");
        }
        else{
            this.side1 = side1;
            this.side2 = side2;
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

    public double getSide1(){
        return side1;
    }

    public double getSide2(){
        return side2;
    }

    @Override
    public double getArea(){
        return (Math.round((side1 * side2) * 100.0)) / 100.0;
    }

    public double getPerimeter(){
        return (2 * (side1 + side2));
    }

    public boolean isSquare(){
        return side1 == side2;
    }

    public boolean isEquals(Rectangle rectangle){
        return ((rectangle.getSide1() == side1) && (rectangle.getSide2() == side2));
    }

    public String toString(){
        return super.toString() + " Rectangle: Side 1: " + this.side1 + " and Side 2: " + this.side2;
    }

}