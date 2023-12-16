package shape;

public class SquareBasePrism extends Prism {
    
     // The side length of the square base

    // Constructor
    public SquareBasePrism(double height, double side) {
        super(height,side);
        
    }

    

    // Implementation of the getBaseArea method for a square
    @Override
    public double getBaseArea() {
        return getSide() * getSide(); // side^2
    }

    @Override
    public String toString() {
        return "SquareBasePrism [sideLength=" + getSide() + ", getHeight()=" + getHeight() + ", getVolume()=" + getVolume() + ", getBaseArea()=" + getBaseArea() + "]";
    }
}
