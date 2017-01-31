package cargoContainer;

/**
 * Created by User on 05.01.2017.
 */
public class test {

    public static void main(String[] args) {
        CargoContainer testContainer = new CargoContainer();

        packageForCargoContainer test1 = new packageForCargoContainer(10, 1, Boxes.SMALL);
        packageForCargoContainer test2 = new packageForCargoContainer(10, 2, Bags.MIDDLE);
        packageForCargoContainer test4 = new packageForCargoContainer(10, 4, Pallets.BIG, 1);
        packageForCargoContainer test3 = new packageForCargoContainer(10, 3, Boxes.BIG);

        testContainer.addPackageToContainer(test1);
        testContainer.addPackageToContainer(test2);
        testContainer.addPackageToContainer(test3);
        testContainer.addPackageToContainer(test4);
        testContainer.addPackageToContainer(test4);

        System.out.println(testContainer.getSpecificTypePackage("Box").toString());
        System.out.println(testContainer.getSpecificTypePackage("Bag").toString());
        System.out.println(testContainer.getSpecificTypePackage("Pallet").toString());
    }
}
