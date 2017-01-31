package cargoContainer;

/**
 * Created by User on 05.01.2017.
 */
public class packageForCargoContainer {
    private static int nextID = 1;
    String type;
    private double weight;
    private double price;
    private double volume;
    private int id;


    public packageForCargoContainer(double weight, double price, Boxes boxes) {
        type = "Box";
        id = nextID;
        nextID++;
        if (weight < 0) throw new IllegalArgumentException("Weight can't be negative");
        else if (weight == 0) throw new IllegalArgumentException("Weight can't be zero");
        else this.weight = weight;
        if (price < 0) throw new IllegalArgumentException("Price can't be negative");
        else if (price == 0) throw new IllegalArgumentException("Price can't be zero");
        this.price = price;
        if (boxes.getVolume() < 0) throw new IllegalArgumentException("Volume can't be negative");
        else if (boxes.getVolume() == 0) throw new IllegalArgumentException("Volume can't be zero");
        if (weight > 30) throw new IllegalArgumentException("Weight is too big it would not feat to Box");
        this.volume = boxes.getVolume();

    }

    public packageForCargoContainer(double weight, double price, Bags bag) {
        type = "Bag";
        id = nextID;
        nextID++;
        if (weight < 0) throw new IllegalArgumentException("Weight can't be negative");
        else if (weight == 0) throw new IllegalArgumentException("Weight can't be zero");
        else this.weight = weight;
        if (price < 0) throw new IllegalArgumentException("Price can't be negative");
        else if (price == 0) throw new IllegalArgumentException("Price can't be zero");
        this.price = price;
        if (bag.getVolume() < 0) throw new IllegalArgumentException("Volume can't be negative");
        else if (bag.getVolume() == 0) throw new IllegalArgumentException("Volume can't be zero");
        if (weight > 70) throw new IllegalArgumentException("Weight is too big it would not feat to Bag");
        this.volume = bag.getVolume();

    }

    public packageForCargoContainer(double weight, double price, Pallets pallet, double height) {
        type = "Pallet";
        id = nextID;
        nextID++;
        if (weight < 0) throw new IllegalArgumentException("Weight can't be negative");
        else if (weight == 0) throw new IllegalArgumentException("Weight can't be zero");
        else this.weight = weight;
        if (price < 0) throw new IllegalArgumentException("Price can't be negative");
        else if (price == 0) throw new IllegalArgumentException("Price can't be zero");
        this.price = price;
        if (pallet.getArea() * height < 0) throw new IllegalArgumentException("Volume can't be negative");
        else if (pallet.getArea() * height == 0) throw new IllegalArgumentException("Volume can't be zero");

        this.volume = pallet.getArea() * height;

    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {


        StringBuilder sb = new StringBuilder("PackageForCargoContainer");
        sb.append(System.lineSeparator());

        sb.append("weight");
        sb.append(" ");
        sb.append(weight);
        sb.append(" ");
        sb.append("price");
        sb.append(" ");
        sb.append(price);
        sb.append(" ");
        sb.append("volume");
        sb.append(" ");
        sb.append(volume);
        sb.append(" ");
        sb.append("ID");
        sb.append(" ");
        sb.append(id);
        sb.append(" ");
        sb.append("type");
        sb.append(" ");
        sb.append(type);
        sb.append(" ");

        return sb.toString();
    }


    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getVolume() {
        return volume;
    }

    public String getType() {
        return type;
    }

}
