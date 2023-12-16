package shape;

public abstract class Prism extends Shape {
    private double side;
    public Prism(double height, double side) {
        super(height);
        this.side = side;
    }

    public double getSide() {
    	return side;
    }
    
    public void setSide(double side) {
    	this.side = side;
    }
    // Using the base area from the specific shape implementation to compute the volume
    @Override
    public double getVolume() {
        return getBaseArea() * getHeight();
    }
    
    // The getBaseArea() method will still remain abstract, 
    // because it is specific to the type of prism (SquareBase, TriangleBase, etc.).
}
