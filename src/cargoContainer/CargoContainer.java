package cargoContainer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by User on 05.01.2017.
 */
public class CargoContainer {

    final double MAX_WEIGHT_CONTAINER_CAN_HOLD = 2000;
    final double MAX_VOLUME_CONTAINER_CAN_HOLD = 5000;
    int idInCargo = 0;
    LinkedHashMap<Integer, packageForCargoContainer> CargoContainer;
    private double currentWeight = 0;
    private double currentVolume = 0;

    public CargoContainer() {
        this.CargoContainer = new LinkedHashMap<>();
    }

    public void addPackageToContainer(packageForCargoContainer n) {

        try {
            double tryAddWeight = currentWeight + n.getWeight();
            if (tryAddWeight >= MAX_WEIGHT_CONTAINER_CAN_HOLD) {
                throw new IllegalArgumentException();
            }
            currentWeight = currentWeight + n.getWeight();
        } catch (IllegalArgumentException b) {
            throw new IllegalArgumentException("Container cant hold this package.There is only" + (MAX_WEIGHT_CONTAINER_CAN_HOLD - getCurrentWeight()) + "kg to hold left");
        }
        try {
            double tryAddVolume = currentVolume + n.getVolume();
            if (tryAddVolume >= MAX_VOLUME_CONTAINER_CAN_HOLD) {
                throw new IllegalArgumentException();
            }
            currentVolume = currentVolume + n.getVolume();
        } catch (IllegalArgumentException b) {
            throw new IllegalArgumentException("Container cant hold this package.There is only " + (MAX_VOLUME_CONTAINER_CAN_HOLD - getCurrentDimensions()) + " m3 to hold left");
        }
        CargoContainer.put(idInCargo, n);
        idInCargo++;

    }


    public void removePackageFromContainer(int index) {

        if (index < 0) throw new IndexOutOfBoundsException("Index cannt be negative");
        this.CargoContainer.remove(index);
    }

    public packageForCargoContainer getPackageFromContainer(int idOfPackage) {
        return this.CargoContainer.get(idOfPackage);

    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getCurrentDimensions() {
        return currentVolume;
    }

    public double getTotalPrice(CargoContainer n) {
        if (this.CargoContainer == null) throw new NullPointerException("Container wasnt created");
        if (this.CargoContainer.isEmpty()) return 0;
        double result = 0;
        for (int i = 0; i < CargoContainer.size(); i++) {
            result = result + n.getPackageFromContainer(i).getPrice();
        }
        return result;
    }

    public double getTotalWeight() {
        return getCurrentWeight();
    }

    public double getAverageDimension() {
        return getCurrentDimensions() / this.CargoContainer.size();
    }

    public double getSize() {
        return CargoContainer.size();
    }

    public LinkedHashMap getPackageOfBothPriceInBoundary(double lowerBoundary, double higherBoundry) {
        if (this.CargoContainer == null) throw new NullPointerException("Container wasnt created");
        if (this.CargoContainer.isEmpty()) return null;
        LinkedHashMap<Integer, packageForCargoContainer> resultCargoContainer = new LinkedHashMap();
        int counter = 0;
        for (int i = 0; i < CargoContainer.size(); i++) {
            if (CargoContainer.get(i).getPrice() >= lowerBoundary && CargoContainer.get(i).getPrice() <= higherBoundry)
                resultCargoContainer.put(counter, CargoContainer.get(i));
            counter++;
        }
        return resultCargoContainer;
    }


    public LinkedHashMap getPackageOfPriceForHigherBoundary(double higherBoundry) {
        if (this.CargoContainer == null) throw new NullPointerException("Container wasnt created");
        if (this.CargoContainer.isEmpty()) return null;
        LinkedHashMap<Integer, packageForCargoContainer> resultCargoContainer = new LinkedHashMap();
        int counter = 0;
        for (int i = 0; i < this.CargoContainer.size(); i++) {
            if (this.CargoContainer.get(i).getPrice() <= higherBoundry)
                resultCargoContainer.put(counter, this.CargoContainer.get(i));
            counter++;
        }
        return resultCargoContainer;
    }

    public LinkedHashMap getPackageOfPriceForLowerBoundary(double lowerBoundary) {
        if (this.CargoContainer == null) throw new NullPointerException("Container wasnt created");
        if (this.CargoContainer.isEmpty()) return null;
        LinkedHashMap<Integer, packageForCargoContainer> resultCargoContainer = new LinkedHashMap();
        int counter = 0;
        for (int i = 0; i < CargoContainer.size(); i++) {
            if (this.CargoContainer.get(i).getPrice() >= lowerBoundary)
                resultCargoContainer.put(counter, CargoContainer.get(i));
            counter++;
        }
        return resultCargoContainer;
    }

    public LinkedHashMap getPackageOfBothWeightInBoundary(double lowerBoundary, double higherBoundary) {

        if (this.CargoContainer == null) throw new NullPointerException("Container wasnt created");
        if (this.CargoContainer.isEmpty()) return null;
        LinkedHashMap<Integer, packageForCargoContainer> resultCargoContainer = new LinkedHashMap();
        int counter = 0;
        for (int i = 0; i < CargoContainer.size(); i++) {
            if (CargoContainer.get(i).getWeight() >= lowerBoundary && CargoContainer.get(i).getWeight() <= higherBoundary)
                resultCargoContainer.put(counter, CargoContainer.get(i));
            counter++;
        }
        return resultCargoContainer;
    }

    public LinkedHashMap getPackageOfWeightForLowerBoundary(double lowerBoundary) {
        if (this.CargoContainer == null) throw new NullPointerException("Container wasnt created");
        if (this.CargoContainer.isEmpty()) return null;
        LinkedHashMap<Integer, packageForCargoContainer> resultCargoContainer = new LinkedHashMap();
        int counter = 0;
        for (int i = 0; i < CargoContainer.size(); i++) {
            if (CargoContainer.get(i).getWeight() >= lowerBoundary)
                resultCargoContainer.put(counter, CargoContainer.get(i));
            counter++;
        }
        return resultCargoContainer;
    }

    public LinkedHashMap getPackageOfWeightForHigherBoundary(double higherBoundry) {
        if (this.CargoContainer == null) throw new NullPointerException("Container wasnt created");
        if (this.CargoContainer.isEmpty()) return null;
        LinkedHashMap<Integer, packageForCargoContainer> resultCargoContainer = new LinkedHashMap();
        int counter = 0;
        for (int i = 0; i < this.CargoContainer.size(); i++) {
            if (this.CargoContainer.get(i).getWeight() <= higherBoundry)
                resultCargoContainer.put(counter, this.CargoContainer.get(i));
            counter++;
        }
        return resultCargoContainer;
    }

    public LinkedHashMap getSpecificTypePackage(String type) {
        LinkedHashMap<Integer, packageForCargoContainer> resultCargoContainer = new LinkedHashMap();
        int counter = 0;
        for (int i = 0; i < this.CargoContainer.size(); i++) {
            if (CargoContainer.get(i).getType().equals(type)) {
                resultCargoContainer.put(counter, CargoContainer.get(i));
                counter++;
            }
        }

        return resultCargoContainer;
    }

    public packageForCargoContainer getPackageForCargoContainer(CargoContainer n, int index) {
        return n.getPackageFromContainer(index);
    }

    @Override
    public String toString() {
        Iterator itr = this.CargoContainer.entrySet().iterator();

        StringBuilder sb = new StringBuilder("CargoContainer");
        sb.append(System.lineSeparator());

        while (itr.hasNext()) {
            Map.Entry ret = (Map.Entry) itr.next();
            sb.append(ret.getKey());
            sb.append(" ");
            sb.append(ret.getValue());
            sb.append(System.lineSeparator());


        }
        return sb.toString();
    }
}


