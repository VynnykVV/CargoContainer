import cargoContainer.Bags;
import cargoContainer.Boxes;
import cargoContainer.Pallets;
import cargoContainer.packageForCargoContainer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 30.01.2017.
 */
public class packageFroCargoContainer {


    packageForCargoContainer test1 = new packageForCargoContainer(1.1, 44, Boxes.BIG);
    packageForCargoContainer test2 = new packageForCargoContainer(2.2, 55, Pallets.MIDDLE, 3);
    packageForCargoContainer test3 = new packageForCargoContainer(3.3, 66, Bags.SMALL);
    packageForCargoContainer test4 = new packageForCargoContainer(3.3, 66, Bags.SMALL);
    packageForCargoContainer test5 = new packageForCargoContainer(3.3, 66, Bags.SMALL);
    packageForCargoContainer test6 = new packageForCargoContainer(3.3, 66, Bags.SMALL);


    @Test
    public void returnWeightOfPackage() {

        Assert.assertEquals(1.1, test1.getWeight(), 0.0001);
        Assert.assertEquals(2.2, test2.getWeight(), 0.0001);
        Assert.assertEquals(3.3, test3.getWeight(), 0.0001);
    }

    @Test
    public void returnPriceOfPackage() {

        Assert.assertEquals(44, test1.getPrice(), 0.0001);
        Assert.assertEquals(55, test2.getPrice(), 0.0001);
        Assert.assertEquals(66, test3.getPrice(), 0.0001);


    }

    @Test
    public void returnVolumeOfPackage() {

        Assert.assertEquals(0.40 * 0.24 * 0.215, test1.getVolume(), 0.0001);
        Assert.assertEquals(1 * 3, test2.getVolume(), 0.0001);
        Assert.assertEquals(0.1, test3.getVolume(), 0.0001);

    }

    @Test
    public void returnTypeOfPackage() {
        Assert.assertEquals("Box", test1.getType());
        Assert.assertEquals("Pallet", test2.getType());
        Assert.assertEquals("Bag", test3.getType());


    }

    @Test
    public void returnIdOfPackage() {

        Assert.assertEquals(test5.getId(), test4.getId() + 1);
        Assert.assertEquals(test6.getId(), test4.getId() + 2);
        Assert.assertTrue(test6.getId() != test5.getId());

    }
}