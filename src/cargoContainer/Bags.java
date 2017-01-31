package cargoContainer;

/**
 * Created by User on 28.01.2017.
 */
public enum Bags {
    SMALL(0.10),
    MIDDLE(0.25),
    BIG(0.50);


    private final double volume;


    Bags(double volume) {

        this.volume = volume;


    }

    public double getVolume() {
        return volume;
    }
}

