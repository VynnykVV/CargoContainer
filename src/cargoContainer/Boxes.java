package cargoContainer;

/**
 * Created by User on 28.01.2017.
 */
public enum Boxes {
    SMALL(0.17, 0.12, 0.10),
    MIDDLE(0.24, 0.17, 0.10),
    BIG(0.40, 0.24, 0.215);
    private final double length;
    private final double width;
    private final double height;

    Boxes(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;


    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getHeight() * getLength() * getWidth();
    }
}
