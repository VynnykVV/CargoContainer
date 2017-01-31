import cargoContainer.Bags;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 30.01.2017.
 */
public class BagsTest {
    @Test
    public void shouldReturnVolume() {

        Assert.assertEquals(0.10, Bags.SMALL.getVolume(), 0.01);
    }

}
