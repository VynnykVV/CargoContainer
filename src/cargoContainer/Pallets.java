package cargoContainer;

/**
 * Created by User on 28.01.2017.
 */
public enum Pallets {
    SMALL(0.49),
    MIDDLE(1),
    BIG(1.5);


    private final double area;


    Pallets(double area) {

        this.area = area;
    }

    public double getArea() {
        return area;
    }
}
