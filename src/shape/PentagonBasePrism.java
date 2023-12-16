package shape;

public class PentagonBasePrism extends Prism {
    
    // Constructor
    public PentagonBasePrism(double height,double side) {
        super(height,side);
     
    }

 

    // Implementation of the getBaseArea method for a pentagon
    @Override
    public double getBaseArea() {
        return (5.0 / 4.0) * Math.tan(Math.PI / 5.0) * getSide() * getSide();
    }

    @Override
    public String toString() {
        return "PentagonBasePrism [sideLength=" + getSide() + ", getHeight()=" + getHeight() + ", getVolume()=" + getVolume() + ", getBaseArea()=" + getBaseArea() + "]";
    }
}
