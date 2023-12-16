package shape;

public class Pyramid extends Shape {
    private double baseSide;  // Assuming a square base

    public Pyramid(double height,double baseSide) {
        super(height);
        this.baseSide = baseSide;
    }

    @Override
    public double getBaseArea() {
        return baseSide * baseSide;
    }

    @Override
    public double getVolume() {
        return (1.0/3.0) * getBaseArea() * getHeight();
    }
    
    @Override
    public String toString() {
        return "Pyramid [baseSide=" + baseSide + ", getHeight()=" + getHeight() + ", getVolume()=" + getVolume() + ", getBaseArea()=" + getBaseArea() + "]";
    }
}
