import cargoContainer.Pallets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 30.01.2017.
 */
public class PalletsTest {
    @Test
    public void shouldGetArea() {
        Assert.assertEquals(1, Pallets.MIDDLE.getArea(), 0.001);


    }
}
