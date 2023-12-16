package utility;

import shape.Shape;
import java.util.Comparator;

public class VolumeComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.getVolume(), s2.getVolume());
    }
}
