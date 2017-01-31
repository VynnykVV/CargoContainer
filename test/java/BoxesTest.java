/**
 * Created by User on 30.01.2017.
 */

import cargoContainer.Boxes;
import org.junit.Assert;
import org.junit.Test;


public class BoxesTest {


    @Test
    public void shouldReturnLengthOfSmallBox() {
        Assert.assertEquals(0.17, Boxes.SMALL.getLength(), 0.01);
    }

    @Test
    public void shouldReturnWidthOfSmallBox() {
        Assert.assertEquals(0.12, Boxes.SMALL.getWidth(), 0.01);
    }

    @Test
    public void shouldReturnHeightOfSmallBox() {
        Assert.assertEquals(0.10, Boxes.SMALL.getHeight(), 0.01);
    }

    @Test
    public void shouldReturnVolumeOfSmallBox() {
        Assert.assertEquals(0.17 * 0.12 * 0.10, Boxes.SMALL.getVolume(), 0.01);

    }


}
