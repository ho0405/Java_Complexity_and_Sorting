package shape;

public class EquilateralTriangleBasePrism extends Prism {
    
     

    // Constructor
    public EquilateralTriangleBasePrism( double height, double side) {
        super(height,side);
        
    }

    
    

    // Implementation of the getBaseArea method for an equilateral triangle
    @Override
    public double getBaseArea() {
        return (Math.sqrt(3) / 4) * getSide() * getSide();
    }

    @Override
    public String toString() {
        return "EquilateralTriangleBasePrism [sideLength=" + getSide() + ", getHeight()=" + getHeight() + ", getVolume()=" + getVolume() + ", getBaseArea()=" + getBaseArea() + "]";
    }
}
