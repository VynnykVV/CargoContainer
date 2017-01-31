package cargoContainer;

/**
 * Created by User on 31.01.2017.
 */
public class Demo {
    public static void main(String[] args) {


        //create several different packages
        //each package has weight, price, type, size(pallets have also height of object on them)
        //all of them have constant volume(except pallets, which have only  area, and height is taken from constructor  )


        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Boxes.SMALL);
        packageForCargoContainer test2 = new packageForCargoContainer(2, 2, Bags.BIG);
        packageForCargoContainer test3 = new packageForCargoContainer(3, 3, Pallets.MIDDLE, 1);
        packageForCargoContainer test4 = new packageForCargoContainer(4, 4, Boxes.MIDDLE);
        packageForCargoContainer test5 = new packageForCargoContainer(5, 5, Bags.BIG);
//Box can hold up to 30 kg
        System.out.println("Попытка создать вместь в ящик больше 30кг в ящик");
        try {
            packageForCargoContainer test6 = new packageForCargoContainer(40, 1, Boxes.BIG);
        } catch (IllegalArgumentException n) {
            System.out.println(n.getMessage());
        }
        ;

// there are such Methods: getVolume,getPrice, getWeight
        System.out.println("Объем маленького ящика");
        System.out.println(test1.getVolume());//Dimensions are 0.17,0.12,0.10. Volume is 0.00204
        System.out.println("Узнать цену ящика");
        System.out.println(test2.getPrice());//Price is 2
        System.out.println("Узнать вес ящика");
        System.out.println(test3.getWeight());//Weight is 3

        // create DemoContainer
        CargoContainer testCargo = new CargoContainer();
        // It has MAX weight and MAX volume to hold;
        System.out.println("Тест на вмещаемость контейнера");

        try {
            packageForCargoContainer test7 = new packageForCargoContainer(401, 1, Pallets.BIG, 1);
            while (true) {
                testCargo.addPackageToContainer(test7);
            }
        } catch (IllegalArgumentException n) {
            System.out.println(n.getMessage());

        }
        ;

        testCargo = new CargoContainer();
        try {
            packageForCargoContainer test8 = new packageForCargoContainer(1, 1, Pallets.BIG, 1000);
            while (true) {
                testCargo.addPackageToContainer(test8);
            }
        } catch (IllegalArgumentException n) {
            System.out.println(n.getMessage());
        }
        ;

// Cargo Container can get Total price, Weight, Volume, averageVolume
        System.out.println("Общий вес, цена, объем, средний объем");
        System.out.println(testCargo.getCurrentWeight());
        System.out.println(testCargo.getTotalPrice(testCargo));
        System.out.println(testCargo.getCurrentDimensions());
        System.out.println(testCargo.getAverageDimension());
// You can get From CargoContainer ListedHashMap of Packages by price and weight, price

        CargoContainer testCargo2 = new CargoContainer();
        testCargo2.addPackageToContainer(test1);
        testCargo2.addPackageToContainer(test2);
        testCargo2.addPackageToContainer(test3);
        testCargo2.addPackageToContainer(test4);
        testCargo2.addPackageToContainer(test5);
        System.out.println("не дороже трешки пока, а там посмотрим");
        System.out.println(testCargo2.getPackageOfPriceForHigherBoundary(3));
        System.out.println();
        System.out.println();
        System.out.println("Больше 3кг");
        System.out.println(testCargo2.getPackageOfWeightForLowerBoundary(3));
        System.out.println();
        System.out.println();
        System.out.println("Нужно только мешки");
        System.out.println(testCargo2.getSpecificTypePackage("Bag"));
        System.out.println();
        System.out.println();
// toString is Also Overrided
        System.out.println("Полностю контейнер");
        System.out.println(testCargo2.toString());


    }
}