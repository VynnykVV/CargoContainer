import cargoContainer.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * Created by User on 30.01.2017.
 */
public class CargoContainerTest {
    CargoContainer testCargo = new CargoContainer();

    @Test
    public void createCargoContainer() {

        Assert.assertNotNull(testCargo);
    }

    @Test
    public void shouldAddPackageToContainer() {
        packageForCargoContainer test1 = new packageForCargoContainer(25, 25, Boxes.BIG);
        testCargo.addPackageToContainer(test1);
        Assert.assertEquals(1, testCargo.getSize(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeptionAfterReachMaxWeight() {
        packageForCargoContainer test1 = new packageForCargoContainer(250, 25, Bags.BIG);
        while (true) {
            testCargo.addPackageToContainer(test1);
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeptionAfterReachMaxVolume() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 25, Bags.BIG);
        while (true) {
            testCargo.addPackageToContainer(test1);
        }


    }

    @Test
    public void shouldDecreaseSizeOfCargoAfterRemovePackageFromContainer() {
        double i;
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Bags.BIG);
        testCargo.addPackageToContainer(test1);
        i = testCargo.getSize();
        testCargo.removePackageFromContainer((int) testCargo.getSize() - 1);
        Assert.assertTrue(i > testCargo.getSize());
    }

    @Test
    public void shouldReturnSameObjectAsWasGiven() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Bags.BIG);
        testCargo.addPackageToContainer(test1);
        Assert.assertEquals(test1, testCargo.getPackageForCargoContainer(testCargo, (int) (testCargo.getSize() - 1)));
    }

    @Test
    public void shouldReturnSumOfWeights() {
        packageForCargoContainer test1 = new packageForCargoContainer(5, 1, Bags.BIG);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        Assert.assertEquals(25, testCargo.getCurrentWeight(), 0);

    }

    @Test
    public void shouldReturnTotalVolume() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Pallets.MIDDLE, 3);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        Assert.assertEquals(15, testCargo.getCurrentDimensions(), 0);

    }

    @Test
    public void shouldReturnTotalPrice() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 11, Pallets.MIDDLE, 3);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        Assert.assertEquals(55, testCargo.getTotalPrice(testCargo), 0);
    }

    @Test(expected = NullPointerException.class)
    public void tryGetPriceOfContainerThatWasntCreated() {
        CargoContainer test2 = null;
        test2.getTotalPrice(test2);

    }

    @Test
    public void tryGetPriceOfEmptyContainer() {

        Assert.assertEquals(0, testCargo.getTotalPrice(testCargo), 0);

    }

    @Test
    public void shouldReturnSumOfWeightsTotal() {
        packageForCargoContainer test1 = new packageForCargoContainer(5, 1, Bags.BIG);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        Assert.assertEquals(25, testCargo.getTotalWeight(), 0);

    }

    @Test
    public void shouldReturnAverageVolumeOfPackage() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 11, Pallets.MIDDLE, 3);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test1);
        Assert.assertEquals(3, testCargo.getAverageDimension(), 0);
    }

    @Test
    public void shouldReturnCargoWithHigherAndLowerPriceBoundariesSetted() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test2 = new packageForCargoContainer(1, 2, Pallets.MIDDLE, 3);
        packageForCargoContainer test3 = new packageForCargoContainer(1, 3, Pallets.MIDDLE, 3);
        packageForCargoContainer test4 = new packageForCargoContainer(1, 4, Pallets.MIDDLE, 3);
        packageForCargoContainer test5 = new packageForCargoContainer(1, 5, Pallets.MIDDLE, 3);
        LinkedHashMap returnCargo = new LinkedHashMap();

        returnCargo.put(1, test2);
        returnCargo.put(2, test3);
        returnCargo.put(3, test4);
        ;
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test2);
        testCargo.addPackageToContainer(test3);
        testCargo.addPackageToContainer(test4);
        testCargo.addPackageToContainer(test5);
        Assert.assertEquals(returnCargo, testCargo.getPackageOfBothPriceInBoundary(2, 4));


    }

    @Test
    public void shouldReturnCargoWithHigherPriceBoundarysSetted() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test2 = new packageForCargoContainer(1, 2, Pallets.MIDDLE, 3);
        packageForCargoContainer test3 = new packageForCargoContainer(1, 3, Pallets.MIDDLE, 3);
        packageForCargoContainer test4 = new packageForCargoContainer(1, 4, Pallets.MIDDLE, 3);
        packageForCargoContainer test5 = new packageForCargoContainer(1, 5, Pallets.MIDDLE, 3);
        LinkedHashMap returnCargo = new LinkedHashMap();

        returnCargo.put(0, test1);
        returnCargo.put(1, test2);
        returnCargo.put(2, test3);

        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test2);
        testCargo.addPackageToContainer(test3);
        testCargo.addPackageToContainer(test4);
        testCargo.addPackageToContainer(test5);
        Assert.assertEquals(returnCargo, testCargo.getPackageOfPriceForHigherBoundary(3));


    }

    @Test
    public void shouldReturnCargoWithLowerPriceBoundarysSetted() {
        CargoContainer testCargo1 = new CargoContainer();
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test2 = new packageForCargoContainer(1, 2, Pallets.MIDDLE, 3);
        packageForCargoContainer test3 = new packageForCargoContainer(1, 3, Pallets.MIDDLE, 3);
        packageForCargoContainer test4 = new packageForCargoContainer(1, 4, Pallets.MIDDLE, 3);
        packageForCargoContainer test5 = new packageForCargoContainer(1, 5, Pallets.MIDDLE, 3);
        LinkedHashMap returnCargo = new LinkedHashMap();


        testCargo1.addPackageToContainer(test1);
        testCargo1.addPackageToContainer(test2);
        testCargo1.addPackageToContainer(test3);
        testCargo1.addPackageToContainer(test4);
        testCargo1.addPackageToContainer(test5);
        returnCargo.put(2, test3);
        returnCargo.put(3, test4);
        returnCargo.put(4, test5);
        Assert.assertEquals(returnCargo, testCargo1.getPackageOfPriceForLowerBoundary(3));


    }

    @Test
    public void shouldReturnCargoWithHigherAndLowerWeightBoundariesSetted() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test2 = new packageForCargoContainer(2, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test3 = new packageForCargoContainer(3, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test4 = new packageForCargoContainer(4, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test5 = new packageForCargoContainer(5, 1, Pallets.MIDDLE, 3);
        LinkedHashMap returnCargo = new LinkedHashMap();

        returnCargo.put(1, test2);
        returnCargo.put(2, test3);
        returnCargo.put(3, test4);
        ;
        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test2);
        testCargo.addPackageToContainer(test3);
        testCargo.addPackageToContainer(test4);
        testCargo.addPackageToContainer(test5);
        Assert.assertEquals(returnCargo, testCargo.getPackageOfBothWeightInBoundary(2, 4));

    }

    @Test
    public void shouldReturnCargoWithHigherWeightBoundarysSetted() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test2 = new packageForCargoContainer(2, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test3 = new packageForCargoContainer(3, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test4 = new packageForCargoContainer(4, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test5 = new packageForCargoContainer(5, 1, Pallets.MIDDLE, 3);

        LinkedHashMap returnCargo = new LinkedHashMap();

        returnCargo.put(0, test1);
        returnCargo.put(1, test2);
        returnCargo.put(2, test3);

        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test2);
        testCargo.addPackageToContainer(test3);
        testCargo.addPackageToContainer(test4);
        testCargo.addPackageToContainer(test5);
        Assert.assertEquals(returnCargo, testCargo.getPackageOfWeightForHigherBoundary(3));


    }

    @Test
    public void shouldReturnCargoWithLowerWeightBoundarysSetted() {
        CargoContainer testCargo1 = new CargoContainer();
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test2 = new packageForCargoContainer(2, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test3 = new packageForCargoContainer(3, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test4 = new packageForCargoContainer(4, 1, Pallets.MIDDLE, 3);
        packageForCargoContainer test5 = new packageForCargoContainer(5, 1, Pallets.MIDDLE, 3);
        LinkedHashMap returnCargo = new LinkedHashMap();


        testCargo1.addPackageToContainer(test1);
        testCargo1.addPackageToContainer(test2);
        testCargo1.addPackageToContainer(test3);
        testCargo1.addPackageToContainer(test4);
        testCargo1.addPackageToContainer(test5);
        returnCargo.put(2, test3);
        returnCargo.put(3, test4);
        returnCargo.put(4, test5);
        Assert.assertEquals(returnCargo, testCargo1.getPackageOfWeightForLowerBoundary(3));


    }

    @Test
    public void shouldReturnSpecficTypeOfPackage() {
        packageForCargoContainer test1 = new packageForCargoContainer(1, 1, Bags.SMALL);
        packageForCargoContainer test2 = new packageForCargoContainer(1, 1, Bags.BIG);
        packageForCargoContainer test3 = new packageForCargoContainer(1, 1, Boxes.SMALL);
        packageForCargoContainer test4 = new packageForCargoContainer(1, 1, Boxes.BIG);
        packageForCargoContainer test5 = new packageForCargoContainer(1, 1, Pallets.SMALL, 1);
        packageForCargoContainer test6 = new packageForCargoContainer(1, 1, Pallets.BIG, 1);
        LinkedHashMap returnCargo = new LinkedHashMap();

        returnCargo.put(0, test3);
        returnCargo.put(1, test4);

        testCargo.addPackageToContainer(test1);
        testCargo.addPackageToContainer(test2);
        testCargo.addPackageToContainer(test3);
        testCargo.addPackageToContainer(test4);
        testCargo.addPackageToContainer(test5);
        testCargo.addPackageToContainer(test6);
        Assert.assertEquals(returnCargo, testCargo.getSpecificTypePackage("Box"));


    }
}