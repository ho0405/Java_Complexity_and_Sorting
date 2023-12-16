package shape;

public class OctagonalBasePrism extends Prism {
    
   

    // Constructor
    public OctagonalBasePrism(double height, double side) {
        super(height, side);
        
    }

   

    // Implementation of the getBaseArea method for an octagon
    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * getSide() * getSide();
    }

    @Override
    public String toString() {
        return "OctagonalBasePrism [sideLength=" + getSide() + ", getHeight()=" + getHeight() + ", getVolume()=" + getVolume() + ", getBaseArea()=" + getBaseArea() + "]";
    }
}
