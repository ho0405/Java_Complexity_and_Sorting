package shape;

public class Cylinder extends Shape {
    private double radius;

    public Cylinder(double height, double radius ) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return getBaseArea() * getHeight();
    }
    
    @Override
    public String toString() {
        return "Cylinder [radius=" + radius + ", getHeight()=" + getHeight() + ", getVolume()=" + getVolume() + ", getBaseArea()=" + getBaseArea() + "]";
    }
}
